package com.empresa.service;

import com.empresa.entity.Proveedor;
import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    // Operaciones CRUD
    List<Proveedor> listarTodos();
    Optional<Proveedor> buscarPorId(Integer id);
    Proveedor guardar(Proveedor proveedor);
    Proveedor actualizar(Integer id, Proveedor proveedor);
    void eliminar(Integer id);

    // Consultas específicas por teléfono
    List<Proveedor> buscarPorTelefonoQueryMethod(String telefono);
    List<Proveedor> buscarPorTelefonoJPQL(String telefono);
    List<Proveedor> buscarPorTelefonoNative(String telefono);
}