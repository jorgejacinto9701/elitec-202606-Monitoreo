package com.empresa.controller;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Autor;
import com.empresa.service.AutorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/autor")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AutorController {

	private final AutorService service;
		
	@PostMapping()
    public ResponseEntity<?> registro(@RequestBody Autor obj){
        obj.setFechaRegistro(LocalDateTime.now());
        obj.setFechaActualizacion(LocalDateTime.now());
        obj.setEstado(1);
        Autor objSalida = service.insertaAutor(obj);
        HashMap<String, Object> salida = new HashMap<>();
        salida.put("data", objSalida);
        salida.put("mensaje", "Registro exitoso con ID ==> " + objSalida.getIdAutor());
        return ResponseEntity.ok(salida);
    }
	
}
