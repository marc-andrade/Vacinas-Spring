package com.example.vacinas.service;

import com.example.vacinas.model.Animal;
import com.example.vacinas.model.Raca;
import com.example.vacinas.repositories.AnimalRepository;
import com.example.vacinas.repositories.RacaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RacaService {

    private final RacaRepository racaRepository;
    private final AnimalRepository animalRepository;

    @Transactional
    public Raca findById(Long id) {
        return racaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Raca insert(Raca entity) {
        return racaRepository.save(entity);
    }

    @Transactional
    public Raca update(Long id, Raca entity) {
        try {
            findById(id);
            return racaRepository.save(entity);

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id) {

        try {
            Raca raca = racaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Raca não encontrada"));
            List<Animal> animais = animalRepository.findByRaca(raca);
            if(animais != null && !animais.isEmpty()) {
                animais.forEach(animal -> animal.setRaca(null));
                animalRepository.saveAll(animais);
            }
            racaRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity violation");
        }
    }
    @Transactional
    public List<Raca> findAll() {
        return racaRepository.findAll();
    }
}
