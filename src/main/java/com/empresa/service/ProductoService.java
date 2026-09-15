package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Producto;

public interface ProductoService {

    // Operaciones CRUD
    public abstract List<Producto> listarTodos();
    public abstract Optional<Producto> buscarPorId(Integer id);
    public abstract Producto guardar(Producto obj);
    public abstract Producto actualizar(Integer id, Producto obj);
    public abstract void eliminar(Integer id);
    
    //Consultas
    public abstract List<Producto> listaPorId(int id);
    public abstract List<Producto> listaPorNombreLike(String nombre);
    
}




