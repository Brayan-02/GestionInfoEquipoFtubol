package com.example.parcial.Controllers;

import com.example.parcial.Models.Entrenador;
import com.example.parcial.Services.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/entrenadores/especialidad")
    public List<Entrenador> obtenerEntrenadoresPorEspecialidad(@RequestParam String especialidad) {
        return entrenadorService.obtenerEntrenadoresPorEspecialidad(especialidad);
    }

    @GetMapping("/entrenadores/equipo")
    public List<Entrenador> obtenerEntrenadoresPorEquipo(@RequestParam long idEquipo) {
        return entrenadorService.obtenerEntrenadoresPorEquipo(idEquipo);
    }

    // Obtener todos los entrenadores
    @GetMapping
    public List<Entrenador> obtenerTodos() {
        return entrenadorService.obtenerTodos();
    }

    // Obtener entrenador por id
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerPorId(@PathVariable Long id) {
        Optional<Entrenador> entrenador = entrenadorService.obtenerPorId(id);
        return entrenador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo entrenador
    @PostMapping
    public ResponseEntity<Entrenador> guardarEntrenador(@RequestBody Entrenador entrenador) {
        Entrenador nuevoEntrenador = entrenadorService.guardarEntrenador(entrenador);
        return new ResponseEntity<>(nuevoEntrenador, HttpStatus.CREATED);
    }

    // Actualizar un entrenador exi
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizarEntrenador(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador entrenadorActualizado = entrenadorService.actualizarEntrenador(id, entrenador);
        return (entrenadorActualizado != null) ? ResponseEntity.ok(entrenadorActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un entrenador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable Long id) {
        return entrenadorService.eliminarEntrenador(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
