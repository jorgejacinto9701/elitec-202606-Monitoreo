package com.empresa.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Docente;
import com.empresa.service.DocenteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/docente")
@RequiredArgsConstructor
public class DocenteController {

    private final DocenteService service;

    @PostMapping()
    public ResponseEntity<?> registro(@RequestBody Docente obj){
        HashMap<String, Object> salida = new HashMap<>();
        obj.setIdDocente(0);
        Docente objSalida = service.insertaDocente(obj);
        salida.put("mensaje", "Docente '"+  objSalida.getNombres()+ "' Registrado de ID : " + objSalida.getIdDocente());
        return ResponseEntity.ok(salida);
    }
}
