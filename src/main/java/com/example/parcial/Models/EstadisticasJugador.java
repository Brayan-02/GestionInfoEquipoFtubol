package com.example.parcial.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class EstadisticasJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstadistica;

    @ManyToOne
    @JoinColumn(name = "idJugador")
    private Jugador idJugador;

    @ManyToOne
    @JoinColumn(name = "idPartido")
    private Partido idPartido;

    private int minutosJugados;
    private  int goles;
    private int asistencias;
    private int tarjAmarillas;
    private int tarRojas;

}
