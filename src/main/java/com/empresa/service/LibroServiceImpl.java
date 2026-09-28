package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Libro;
import com.empresa.repository.LibroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService{

    private final  LibroRepository repository;

    @Override
    public List<Libro> listaPorTitulo(String filtro) {
        return repository.consultaDinamica(filtro);
    }

    @Override
    public Libro insertaLibro(Libro obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaLibro(int id) {
        repository.deleteById(id);
    }

}
