package com.example.parcial.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;     // Identificador del equipo


    private String nombre;    // Nombre del equipo
    private String ciudad;    // Ciudad base del equipo
    private LocalDate fundacion; // Fecha de fundación

}
