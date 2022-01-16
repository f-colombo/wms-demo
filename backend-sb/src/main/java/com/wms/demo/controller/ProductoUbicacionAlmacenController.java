package com.wms.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.demo.model.ProductoUbicacionAlmacen;
import com.wms.demo.repository.ProductoUbicacionAlmacenRepository;

//@CrossOrigin(origins = "")
@RestController
@RequestMapping("/api/v1")
public class ProductoUbicacionAlmacenController {

	@Autowired
	ProductoUbicacionAlmacenRepository productoUbicacionAlmacenRepository;

	@GetMapping("/productos/ubicaciones")
	public ResponseEntity<List<ProductoUbicacionAlmacen>> getAll() {
		try {
			List<ProductoUbicacionAlmacen> list = productoUbicacionAlmacenRepository.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<ProductoUbicacionAlmacen>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<ProductoUbicacionAlmacen>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
