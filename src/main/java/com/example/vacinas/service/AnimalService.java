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
public class AnimalService {

    private final AnimalRepository racaRepository;

    @Transactional
    public Animal findById(Long id) {
        return racaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Animal insert(Animal entity) {
        return racaRepository.save(entity);
    }

    @Transactional
    public Animal update(Long id, Animal entity) {
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
    public List<Animal> findAll() {
        return racaRepository.findAll();
    }
}
