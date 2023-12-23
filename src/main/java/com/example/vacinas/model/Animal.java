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
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 100)
    private String nome;
    @NotNull
    @Size(min = 1, max = 100)
    private String dono;
    @NotNull
    @Size(min = 1, max = 9)
    private String telefone;
    @NotNull
    private String tipo;
    private LocalDate nascimento;
    @JoinColumn(name = "raca", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private Raca raca;

}
