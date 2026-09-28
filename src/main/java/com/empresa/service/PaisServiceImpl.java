package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Pais;
import com.empresa.repository.PaisRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    @Override
    public List<Pais> listarPaises() {
        return paisRepository.findAll();
    }
}
