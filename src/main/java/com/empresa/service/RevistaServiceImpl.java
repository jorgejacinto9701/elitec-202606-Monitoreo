package com.empresa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.entity.Revista;
import com.empresa.repository.RevistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RevistaServiceImpl implements RevistaService {

    private final RevistaRepository revistaRepository;

    @Override
    public List<Revista> listarTodas() {
        return revistaRepository.findAll();
    }

    @Override
    public Optional<Revista> obtenerPorId(Integer id) {
        return revistaRepository.findById(id);
    }

    @Override
    public Revista registrar(Revista revista) {
        return revistaRepository.save(revista);
    }

    @Override
    public Revista actualizar(Integer id, Revista revista) {
        return revistaRepository.findById(id).map(r -> {
            r.setNombre(revista.getNombre());
            r.setFechaCreacion(revista.getFechaCreacion());
            r.setEstado(revista.getEstado());
            r.setPais(revista.getPais());
            r.setTipoRevista(revista.getTipoRevista());
            return revistaRepository.save(r);
        }).orElseThrow(() -> new RuntimeException("Revista no encontrada con ID: " + id));
    }

    @Override
    public boolean eliminar(Integer id) {
        if (revistaRepository.existsById(id)) {
            revistaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Revista> buscarPorRangoFechaCreacion(LocalDate fechaInicio, LocalDate fechaFin) {
        return revistaRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    }
}