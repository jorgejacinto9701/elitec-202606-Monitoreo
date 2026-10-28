package com.empresa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Revista;


public interface RevistaRepository extends JpaRepository<Revista, Integer> {

    // Consulta por Rango de Fecha de Creación
    @Query("SELECT r FROM Revista r WHERE r.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<Revista> findByFechaCreacionBetween(
            @Param("fechaInicio") LocalDate fechaInicio, 
            @Param("fechaFin") LocalDate fechaFin
    );
}