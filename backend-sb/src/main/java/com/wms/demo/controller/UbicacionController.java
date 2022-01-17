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

import com.wms.demo.model.Ubicacion;
import com.wms.demo.repository.UbicacionRepository;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/v1")
public class UbicacionController {

	@Autowired
	UbicacionRepository ubicacionRepository;

	@GetMapping("/ubicaciones")
	public ResponseEntity<List<Ubicacion>> getAll() {
		try {
			List<Ubicacion> list = ubicacionRepository.findAll();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Ubicacion>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Ubicacion>>(list, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
