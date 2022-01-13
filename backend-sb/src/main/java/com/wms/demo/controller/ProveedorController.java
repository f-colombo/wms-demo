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

import com.wms.demo.model.Proveedor;
import com.wms.demo.repository.ProveedorRepository;

//@CrossOrigin(origins = "")
@RestController
@RequestMapping("/api/v1")
public class ProveedorController {

	@Autowired
	ProveedorRepository proveedorRepository;

	@GetMapping("/proveedores")
	public ResponseEntity<List<Proveedor>> findAll() {
		try {
			List<Proveedor> list = proveedorRepository.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Proveedor>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Proveedor>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/proveedores/{id}")
	public ResponseEntity<Proveedor> getSingleCustomer(@PathVariable Integer id) {
		try {
			Optional<Proveedor> proveedor = proveedorRepository.findById(id);

			if (proveedor.isPresent()) {
				return new ResponseEntity<Proveedor>(proveedor.get(), HttpStatus.OK);
			}

			return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
