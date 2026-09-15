package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	public abstract List<Producto> findByIdProducto(int idProducto);
	public abstract List<Producto> findByNombreLike(String nombre);

	
}
