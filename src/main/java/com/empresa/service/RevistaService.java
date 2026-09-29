package com.empresa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.empresa.entity.Revista;

public interface RevistaService {
    List<Revista> listarTodas();
    Optional<Revista> obtenerPorId(Integer id);
    Revista registrar(Revista revista);
    Revista actualizar(Integer id, Revista revista);
    boolean eliminar(Integer id);
    List<Revista> buscarPorRangoFechaCreacion(LocalDate fechaInicio, LocalDate fechaFin);
}