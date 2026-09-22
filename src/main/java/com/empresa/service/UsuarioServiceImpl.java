package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UsuarioResponseDto buscaPorId(int idUsuario) {
		Usuario objUsuario = repository.findById(idUsuario).orElse(null);
		if (objUsuario == null) {
			return null;
		}else {
			UsuarioResponseDto objDto = new UsuarioResponseDto();
			objDto.setIdUsuario(objUsuario.getIdUsuario());
			objDto.setNombreCompleto(
					objUsuario.getNombres().
					concat(" ").
					concat(objUsuario.getApellidos()));
			objDto.setDni(objUsuario.getDni());
			objDto.setCorreo(objUsuario.getCorreo());
			return objDto;
		}
	}

}
