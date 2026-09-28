package com.empresa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	
	@GetMapping("/porId/{idUsuario}")
	public ResponseEntity<?> buscaUsuario(@PathVariable int idUsuario) {
		 UsuarioResponseDto objDto = usuarioService.buscaPorId(idUsuario);
		 return ResponseEntity.ok(objDto);
	}
}
