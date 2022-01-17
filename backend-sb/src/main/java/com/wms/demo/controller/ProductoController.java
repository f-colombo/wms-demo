package com.wms.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.demo.model.Producto;
import com.wms.demo.repository.ProductoRepository;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/v1")
public class ProductoController {

	@Autowired
	ProductoRepository productoRepository;

	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getAll() {
		try {
			List<Producto> list = productoRepository.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getSingle(@PathVariable Integer id) {
		try {
			Optional<Producto> producto = productoRepository.findById(id);

			if (producto.isPresent()) {
				return new ResponseEntity<Producto>(producto.get(), HttpStatus.OK);
			}

			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/proveedores/{providerId}/productos")
	public ResponseEntity<List<Producto>> getByProvider(@PathVariable Integer providerId) {
		try {
			List<Producto> list = productoRepository.findByIdProveedor(providerId);

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
