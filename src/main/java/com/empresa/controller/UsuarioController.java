package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.dto.UsuarioResponseDto;
import com.empresa.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/porId/{idUsuario}")
	public ResponseEntity<?> buscaUsuario(@PathVariable int idUsuario) {
		 UsuarioResponseDto objDto = service.buscaPorId(idUsuario);
		 return ResponseEntity.ok(objDto);
	}
}
