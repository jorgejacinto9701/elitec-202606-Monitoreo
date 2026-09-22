package com.empresa.service;

import com.empresa.dto.UsuarioResponseDto;

public interface UsuarioService {
	public abstract UsuarioResponseDto buscaPorId(int idUsuario);
}
