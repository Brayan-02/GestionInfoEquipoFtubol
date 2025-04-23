package com.example.parcial.Services;

import com.example.parcial.Models.Entrenador;
import com.example.parcial.Repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;


    public List<Entrenador> obtenerEntrenadoresPorEspecialidad(String especialidad) {
        return entrenadorRepository.findByEspecialidad(especialidad);
    }

    public List<Entrenador> obtenerEntrenadoresPorEquipo(long idEquipo) {
        return entrenadorRepository.findByIdEquipo(idEquipo);
    }


    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> obtenerPorId(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardarEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador actualizarEntrenador(Long id, Entrenador entrenador) {
        if (entrenadorRepository.existsById(id)) {
            entrenador.setIdEntrenador(id);
            return entrenadorRepository.save(entrenador);
        }
        return null;
    }

    public boolean eliminarEntrenador(Long id) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
