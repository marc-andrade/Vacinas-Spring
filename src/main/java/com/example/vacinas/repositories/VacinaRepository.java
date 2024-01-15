package com.example.vacinas.repositories;

import com.example.vacinas.model.Animal;
import com.example.vacinas.model.Raca;
import com.example.vacinas.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
    List<Vacina> findByAnimal(Animal animal);
}
