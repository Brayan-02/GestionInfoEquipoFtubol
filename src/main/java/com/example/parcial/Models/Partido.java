package com.example.parcial.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPartido;

    private LocalDate fecha;
    private String estadio;
    private int golesLocal;
    private int golesVisitante;


    @ManyToOne
    @JoinColumn(name = "idEquipoLocal")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "idEquipovisitante")
    private Equipo equipoVisitante;

}
