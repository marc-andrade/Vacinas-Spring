package com.example.vacinas.repositories;

import com.example.vacinas.model.Animal;
import com.example.vacinas.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacaRepository extends JpaRepository<Raca, Long> {
}
