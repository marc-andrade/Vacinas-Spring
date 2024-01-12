package com.example.vacinas.repositories;

import com.example.vacinas.model.Animal;
import com.example.vacinas.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByRaca(Raca raca);
}
