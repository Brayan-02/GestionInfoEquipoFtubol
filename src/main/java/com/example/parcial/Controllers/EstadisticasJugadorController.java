package com.example.parcial.Controllers;

import com.example.parcial.Models.EstadisticasJugador;
import com.example.parcial.Services.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estadisticasjugadores")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @GetMapping
    public List<EstadisticasJugador> obtenerTodos() {
        return estadisticasJugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> obtenerPorId(@PathVariable Long id) {
        Optional<EstadisticasJugador> estadisticasJugador = estadisticasJugadorService.obtenerPorId(id);
        return estadisticasJugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadisticasJugador> guardarEstadisticasJugador(@RequestBody EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador nuevaEstadistica = estadisticasJugadorService.guardarEstadisticasJugador(estadisticasJugador);
        return new ResponseEntity<>(nuevaEstadistica, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> actualizarEstadisticasJugador(@PathVariable Long id, @RequestBody EstadisticasJugador estadisticasJugador) {
        EstadisticasJugador estadisticaActualizada = estadisticasJugadorService.actualizarEstadisticasJugador(id, estadisticasJugador);
        return (estadisticaActualizada != null) ? ResponseEntity.ok(estadisticaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadisticasJugador(@PathVariable Long id) {
        return estadisticasJugadorService.eliminarEstadisticasJugador(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
