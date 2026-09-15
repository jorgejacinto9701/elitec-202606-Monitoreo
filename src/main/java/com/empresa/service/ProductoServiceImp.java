package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Producto;
import com.empresa.repository.ProductoRepository;

@Service	
public class ProductoServiceImp implements ProductoService{

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Producto> buscarPorId(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Producto guardar(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Producto actualizar(Integer id, Producto obj) {
		obj.setIdProducto(id);
		return repository.save(obj);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Producto> listaPorId(int id) {
		return repository.findByIdProducto(id);
	}

	@Override
	public List<Producto> listaPorNombreLike(String nombre) {
		return repository.findByNombreLike(nombre);
	}

}
