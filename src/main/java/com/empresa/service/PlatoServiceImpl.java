package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Plato;
import com.empresa.repository.PlatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlatoServiceImpl implements PlatoService{

    private final  PlatoRepository repository;

    @Override
    public List<Plato> listaPorNombre(String filtro) {
        return repository.consultaDinamica(filtro);
    }

    @Override
    public Plato insertaPlato(Plato obj) {
        return repository.save(obj);
    }

    public void eliminaPlato(int id) {
        repository.deleteById(id);
    }
}
