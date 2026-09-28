package com.empresa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Pais;
import com.empresa.service.PaisService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/paises")
@RequiredArgsConstructor
public class PaisController {

	private final PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> listarPaises() {
        List<Pais> lista = paisService.listarPaises();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}