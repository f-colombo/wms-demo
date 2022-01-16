package com.wms.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.wms.demo.contract.dashboard.DashboardEntidadContrat;
import com.wms.demo.contract.dashboard.DashboardResponseContract;
import com.wms.demo.model.Producto;
import com.wms.demo.model.Proveedor;
import com.wms.demo.model.Ubicacion;
import com.wms.demo.repository.ProductoRepository;
import com.wms.demo.repository.ProveedorRepository;
import com.wms.demo.repository.UbicacionRepository;

//@CrossOrigin(origins = "")
@RestController
@RequestMapping("/api/v1")
public class DashboardController {

	@Autowired
	ProveedorRepository proveedorRepository;

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	UbicacionRepository ubicacionRepository;

	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponseContract> getItems() {
		try {

			
			// Entidades.Proveedores
			List<Proveedor> proveedores = proveedorRepository.findAll();
			DashboardEntidadContrat entidadProveedores = new DashboardEntidadContrat();
			entidadProveedores.setSvg(
					"M19.428 15.428a2 2 0 00-1.022-.547l-2.387-.477a6 6 0 00-3.86.517l-.318.158a6 6 0 01-3.86.517L6.05 15.21a2 2 0 00-1.806.547M8 4h8l-1 1v5.172a2 2 0 00.586 1.414l5 5c1.26 1.26.367 3.414-1.415 3.414H4.828c-1.782 0-2.674-2.154-1.414-3.414l5-5A2 2 0 009 10.172V5L8 4z");
			entidadProveedores.setNombre("Proveedores");
			entidadProveedores.setCantidad(proveedores.size());
			entidadProveedores.setTexto("Laboratorios fabricantes de las medicinas en venta");
			entidadProveedores.setEnlace("/proveedores");

			// Entidades.Productos
			List<Producto> productos = productoRepository.findAll();
			DashboardEntidadContrat entidadProductos = new DashboardEntidadContrat();
			entidadProductos.setSvg("M20 7l-8-4-8 4m16 0l-8 4m8-4v10l-8 4m0-10L4 7m8 4v10M4 7v10l8 4");
			entidadProductos.setNombre("Productos");
			entidadProductos.setCantidad(productos.size());
			entidadProductos.setTexto("Medicinas habilitadas para la venta y distribución");
			entidadProductos.setEnlace("/productos");

			// Entidades.Ubicaciones
			List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
			DashboardEntidadContrat entidadUbicaciones = new DashboardEntidadContrat();
			entidadUbicaciones.setSvg("M3 10h18M3 14h18m-9-4v8m-7 0h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z");
			entidadUbicaciones.setNombre("Ubicaciones");
			entidadUbicaciones.setCantidad(ubicaciones.size());
			entidadUbicaciones.setTexto("Ubicaciones disponibles para el almacenaje de las medicinas");
			entidadUbicaciones.setEnlace("/ubicaciones");
			
			// Entidades
			List<DashboardEntidadContrat> listEntidades = new ArrayList<>(
					Arrays.asList(entidadProveedores, entidadProductos, entidadUbicaciones));
			
			

			DashboardResponseContract responseContract = new DashboardResponseContract();
			responseContract.setEntidades(listEntidades);

			return new ResponseEntity<DashboardResponseContract>(responseContract, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
