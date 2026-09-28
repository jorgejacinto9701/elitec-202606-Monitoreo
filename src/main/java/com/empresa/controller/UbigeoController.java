package com.empresa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Ubigeo;
import com.empresa.service.UbigeoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ubigeo")
@RequiredArgsConstructor
public class UbigeoController {

    private final UbigeoService service;

    @GetMapping("/listaDepartamento")
    public List<String> lstDepartamento(){
        return service.listaDepartamento();
    }
    @GetMapping("/listaProvincia/{dep}")
    public List<String> lstProvincia(@PathVariable String dep){
        return service.listaProvincia(dep);
    }
    @GetMapping("/listaDistrito/{dep}/{pro}")
    public List<Ubigeo> lstDistrito(@PathVariable String dep,@PathVariable String pro){
        return service.listaDistrito(dep, pro);
    }
}
