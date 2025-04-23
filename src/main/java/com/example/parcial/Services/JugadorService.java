package com.example.parcial.Services;

import com.example.parcial.Models.Jugador;
import com.example.parcial.Repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> obtenerPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador guardarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador actualizarJugador(Long id, Jugador jugador) {
        if (jugadorRepository.existsById(id)) {
            jugador.setIdJugador(id);
            return jugadorRepository.save(jugador);
        }
        return null;
    }

    public boolean eliminarJugador(Long id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
