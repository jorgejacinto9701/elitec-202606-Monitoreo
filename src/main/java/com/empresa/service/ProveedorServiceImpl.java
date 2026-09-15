package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Proveedor;
import com.empresa.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<Proveedor> buscarPorId(Integer id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedorDetails) {
        return proveedorRepository.findById(id).map(proveedor -> {
            proveedor.setRazonSocial(proveedorDetails.getRazonSocial());
            proveedor.setTelefono(proveedorDetails.getTelefono());
            proveedor.setEmail(proveedorDetails.getEmail());
            return proveedorRepository.save(proveedor);
        }).orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<Proveedor> buscarPorTelefonoQueryMethod(String telefono) {
        return proveedorRepository.findByTelefono(telefono);
    }

    @Override
    public List<Proveedor> buscarPorTelefonoJPQL(String telefono) {
        return proveedorRepository.buscarPorTelefonoJPQL(telefono);
    }

    @Override
    public List<Proveedor> buscarPorTelefonoNative(String telefono) {
        return proveedorRepository.buscarPorTelefonoNative(telefono);
    }
}