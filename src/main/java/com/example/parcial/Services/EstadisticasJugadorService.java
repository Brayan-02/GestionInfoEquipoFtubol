package com.example.parcial.Services;

import com.example.parcial.Models.EstadisticasJugador;
import com.example.parcial.Repositories.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public List<EstadisticasJugador> obtenerTodos() {
        return estadisticasJugadorRepository.findAll();
    }

    public Optional<EstadisticasJugador> obtenerPorId(Long id) {
        return estadisticasJugadorRepository.findById(id);
    }

    public EstadisticasJugador guardarEstadisticasJugador(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }

    public EstadisticasJugador actualizarEstadisticasJugador(Long id, EstadisticasJugador estadisticasJugador) {
        if (estadisticasJugadorRepository.existsById(id)) {
            estadisticasJugador.setIdEstadistica(id);
            return estadisticasJugadorRepository.save(estadisticasJugador);
        }
        return null;
    }

    public boolean eliminarEstadisticasJugador(Long id) {
        if (estadisticasJugadorRepository.existsById(id)) {
            estadisticasJugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

