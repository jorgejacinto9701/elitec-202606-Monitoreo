package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImp implements AlumnoService {

	private final  AlumnoRepository repository;

	@Override
	public List<Alumno> listaTodos() {
		return repository.findByOrderByApellidosAsc();
	}

	
}
