package com.example.parcial.Controllers;

import com.example.parcial.Models.Partido;
import com.example.parcial.Services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> obtenerTodos() {
        return partidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
        Optional<Partido> partido = partidoService.obtenerPorId(id);
        return partido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Partido> guardarPartido(@RequestBody Partido partido) {
        Partido nuevoPartido = partidoService.guardarPartido(partido);
        return new ResponseEntity<>(nuevoPartido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizarPartido(@PathVariable Long id, @RequestBody Partido partido) {
        Partido partidoActualizado = partidoService.actualizarPartido(id, partido);
        return (partidoActualizado != null) ? ResponseEntity.ok(partidoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable Long id) {
        return partidoService.eliminarPartido(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
