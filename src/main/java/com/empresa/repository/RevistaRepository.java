package com.empresa.repository;

import com.empresa.entity.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Integer> {

    // Consulta por Rango de Fecha de Creación
    @Query("SELECT r FROM Revista r WHERE r.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<Revista> findByFechaCreacionBetween(
            @Param("fechaInicio") LocalDate fechaInicio, 
            @Param("fechaFin") LocalDate fechaFin
    );
}