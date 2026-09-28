package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Deporte;
import com.empresa.repository.DeporteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeporteServiceImpl implements DeporteService{

    private final DeporteRepository repository;

    @Override
    public List<Deporte> listaTodos() {
        return repository.findAll();
    }
}
