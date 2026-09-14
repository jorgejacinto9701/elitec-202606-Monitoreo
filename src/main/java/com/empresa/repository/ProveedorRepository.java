package com.empresa.repository;

import com.empresa.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // 1. Query Method (Generado automáticamente por nombre de método)
    List<Proveedor> findByTelefono(String telefono);

    // 2. JPQL Query (Orientado a la entidad Java)
    @Query("SELECT p FROM Proveedor p WHERE p.telefono = :telefono")
    List<Proveedor> buscarPorTelefonoJPQL(@Param("telefono") String telefono);

    // 3. Native Query (Consulta SQL pura contra la base de datos)
    @Query(value = "SELECT * FROM proveedor WHERE telefono = :telefono", nativeQuery = true)
    List<Proveedor> buscarPorTelefonoNative(@Param("telefono") String telefono);
}