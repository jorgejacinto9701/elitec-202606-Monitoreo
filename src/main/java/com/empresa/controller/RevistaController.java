package com.empresa.controller;

import com.empresa.entity.Revista;
import com.empresa.service.RevistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/revistas")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class RevistaController {

    private final RevistaService revistaService;

    // GET: Listar todas
    @GetMapping
    public ResponseEntity<List<Revista>> listarTodas() {
        return ResponseEntity.ok(revistaService.listarTodas());
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Revista> obtenerPorId(@PathVariable Integer id) {
        return revistaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Crear Revista
    @PostMapping
    public ResponseEntity<Revista> registrar(@RequestBody Revista revista) {
        Revista nueva = revistaService.registrar(revista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // PUT: Actualizar Revista
    @PutMapping("/{id}")
    public ResponseEntity<Revista> actualizar(@PathVariable Integer id, @RequestBody Revista revista) {
        try {
            Revista actualizada = revistaService.actualizar(id, revista);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar Revista
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (revistaService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // GET: Consulta por rango de fecha de creación
    // Ejemplo REST: GET /api/revistas/por-fecha-creacion?inicio=2020-01-01&fin=2023-12-31
    @GetMapping("/por-fecha-creacion")
    public ResponseEntity<List<Revista>> buscarPorRangoFechaCreacion(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List<Revista> revistas = revistaService.buscarPorRangoFechaCreacion(fechaInicio, fechaFin);
        return ResponseEntity.ok(revistas);
    }
}