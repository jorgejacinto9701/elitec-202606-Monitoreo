package com.empresa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Producto;
import com.empresa.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductoController {

	private final ProductoService productoService;
	
	@GetMapping
	public List<Producto> listaTodos(){
		return productoService.listarTodos();
	}
	
	@GetMapping("/porId/{id}")
	public List<Producto> listaPorId(@PathVariable int id){
		return productoService.listaPorId(id);
	}
	
	@GetMapping("/porNombre/{nombre}")
	public List<Producto> listaPorNombre(@PathVariable String nombre){
		return productoService.listaPorNombreLike(nombre + "%");
	}
	
	@PostMapping
	public ResponseEntity<Producto> guardar(@RequestBody Producto obj) {
		Producto objRegistrado = productoService.guardar(obj);
		return new ResponseEntity<>(objRegistrado, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto obj) {
        try {
        	Producto objActualizado = productoService.actualizar(id, obj);
            return ResponseEntity.ok(objActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}






