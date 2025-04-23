package com.example.parcial.Controllers;

import com.example.parcial.Models.Jugador;
import com.example.parcial.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> obtenerTodos() {
        return jugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id) {
        Optional<Jugador> jugador = jugadorService.obtenerPorId(id);
        return jugador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jugador> guardarJugador(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.guardarJugador(jugador);
        return new ResponseEntity<>(nuevoJugador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugador) {
        Jugador jugadorActualizado = jugadorService.actualizarJugador(id, jugador);
        return (jugadorActualizado != null) ? ResponseEntity.ok(jugadorActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
        return jugadorService.eliminarJugador(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
