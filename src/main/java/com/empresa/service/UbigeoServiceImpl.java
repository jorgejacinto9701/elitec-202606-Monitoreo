package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Ubigeo;
import com.empresa.repository.UbigeoRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl implements  UbigeoService{

     private final UbigeoRepository repository;

    @Override
    public List<String> listaDepartamento() {
        return repository.listaDepartamento();
    }

    @Override
    public List<String> listaProvincia(String departamento) {
        return repository.listaProvincia(departamento);
    }

    @Override
    public List<Ubigeo> listaDistrito(String departamento, String provincia) {
        return repository.listaDistrito(departamento,provincia);
    }
}
