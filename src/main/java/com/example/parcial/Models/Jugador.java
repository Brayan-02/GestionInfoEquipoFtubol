package com.example.parcial.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idJugador;


    private String nombre;
    private String posicion;
    private int dorsal;
    private LocalDate fec_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;

}
