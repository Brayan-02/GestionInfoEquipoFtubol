package com.example.parcial.Services;

import com.example.parcial.Models.Partido;
import com.example.parcial.Repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> obtenerPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido guardarPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido actualizarPartido(Long id, Partido partido) {
        if (partidoRepository.existsById(id)) {
            partido.setIdPartido(id);
            return partidoRepository.save(partido);
        }
        return null;
    }

    public boolean eliminarPartido(Long id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
