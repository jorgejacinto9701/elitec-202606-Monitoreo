package com.empresa.controller;

import com.empresa.entity.Proveedor;
import com.empresa.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // GET: Listar todos
    @GetMapping
    public ResponseEntity<List<Proveedor>> listar() {
        return ResponseEntity.ok(proveedorService.listarTodos());
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> buscarPorId(@PathVariable Integer id) {
        return proveedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Crear nuevo
    @PostMapping
    public ResponseEntity<Proveedor> guardar(@RequestBody Proveedor proveedor) {
        return new ResponseEntity<>(proveedorService.guardar(proveedor), HttpStatus.CREATED);
    }

    // PUT: Actualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        try {
            return ResponseEntity.ok(proveedorService.actualizar(id, proveedor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // GET: Consulta por teléfono mediante QueryMethod
    @GetMapping("/telefono/qm/{telefono}")
    public ResponseEntity<List<Proveedor>> buscarPorTelefonoQM(@PathVariable String telefono) {
        return ResponseEntity.ok(proveedorService.buscarPorTelefonoQueryMethod(telefono));
    }

    // GET: Consulta por teléfono mediante JPQL
    @GetMapping("/telefono/jpql/{telefono}")
    public ResponseEntity<List<Proveedor>> buscarPorTelefonoJPQL(@PathVariable String telefono) {
        return ResponseEntity.ok(proveedorService.buscarPorTelefonoJPQL(telefono));
    }

    // GET: Consulta por teléfono mediante Native Query
    @GetMapping("/telefono/native/{telefono}")
    public ResponseEntity<List<Proveedor>> buscarPorTelefonoNative(@PathVariable String telefono) {
        return ResponseEntity.ok(proveedorService.buscarPorTelefonoNative(telefono));
    }
}