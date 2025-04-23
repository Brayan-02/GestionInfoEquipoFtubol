package com.example.parcial.Controllers;

import com.example.parcial.Models.Equipo;
import com.example.parcial.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> obtenerTodos() {
        return equipoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Long id) {
        Optional<Equipo> equipo = equipoService.obtenerPorId(id);
        return equipo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipo> guardarEquipo(@RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.guardarEquipo(equipo);
        return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        Equipo equipoActualizado = equipoService.actualizarEquipo(id, equipo);
        return (equipoActualizado != null) ? ResponseEntity.ok(equipoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        return equipoService.eliminarEquipo(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
