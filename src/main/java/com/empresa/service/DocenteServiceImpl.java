package com.empresa.service;

import org.springframework.stereotype.Service;

import com.empresa.entity.Docente;
import com.empresa.repository.DocenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocenteServiceImpl implements  DocenteService{

    
    private final DocenteRepository repository;

    @Override
    public Docente insertaDocente(Docente obj) {
        return repository.save(obj);
    }
}
