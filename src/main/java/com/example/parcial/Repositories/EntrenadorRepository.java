package com.example.parcial.Repositories;
import com.example.parcial.Models.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

    // Consulta nativa para obtener entrenadores por especialidad
    @Query(value = "SELECT * FROM entrenador WHERE especialidad = :especialidad", nativeQuery = true)
    List<Entrenador> findByEspecialidad(String especialidad);

    // Consulta nativa para obtener entrenadores por id de equipo
    @Query(value = "SELECT e.* FROM entrenador e INNER JOIN equipo eq ON e.id_equipo = eq.id_equipo WHERE eq.id_equipo = :idEquipo", nativeQuery = true)
    List<Entrenador> findByIdEquipo(long idEquipo);



}
