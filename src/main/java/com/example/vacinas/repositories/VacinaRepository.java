package com.example.vacinas.repositories;

import com.example.vacinas.model.Raca;
import com.example.vacinas.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
