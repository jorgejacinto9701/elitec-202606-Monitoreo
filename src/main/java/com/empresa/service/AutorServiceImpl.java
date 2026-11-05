package com.empresa.service;

import org.springframework.stereotype.Service;

import com.empresa.entity.Autor;
import com.empresa.repository.AutorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

	private final AutorRepository autorRepository;
	
	@Override
	public Autor insertaAutor(Autor obj) {
		return autorRepository.save(obj);
	}

}
