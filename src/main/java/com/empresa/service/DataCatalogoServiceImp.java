package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.entity.DataCatalogo;
import com.empresa.repository.DataCatalogoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataCatalogoServiceImp implements DataCatalogoService {

	private final   DataCatalogoRepository repository;

	@Override
	public List<DataCatalogo> listaDataCatalogo(int idTipo) {
		return repository.listaDataCatalogo(idTipo);
	}

}
