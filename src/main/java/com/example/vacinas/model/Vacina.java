package com.example.vacinas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vacina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @NotNull
    private LocalDate data;
    @JoinColumn(name = "animal", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Animal animal;
}
