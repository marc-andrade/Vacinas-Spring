package com.example.vacinas.service;

import com.example.vacinas.model.Vacina;
import com.example.vacinas.repositories.VacinaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    @Transactional
    public Vacina findById(Long id) {
        return vacinaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @Transactional
    public Vacina insert(Vacina entity) {
        return vacinaRepository.save(entity);
    }

    @Transactional
    public Vacina update(Long id, Vacina entity) {
        try {
            findById(id);
            return vacinaRepository.save(entity);

        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id) {

        try {
            vacinaRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Integrity violation");
        }
    }
    @Transactional
    public List<Vacina> findAll() {
        return vacinaRepository.findAll();
    }
}
