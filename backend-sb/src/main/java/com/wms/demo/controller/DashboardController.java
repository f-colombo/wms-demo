package com.wms.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.wms.demo.contract.dashboard.DashboardEntidadContrat;
import com.wms.demo.contract.dashboard.DashboardResponseContract;
import com.wms.demo.contract.dashboard.DashboardTransaccionContract;
import com.wms.demo.contract.dashboard.DashboardValorInventarioContract;
import com.wms.demo.model.Producto;
import com.wms.demo.model.ProductoUbicacionLote;
import com.wms.demo.model.Proveedor;
import com.wms.demo.model.Ubicacion;
import com.wms.demo.repository.ProductoDetalleRepository;
import com.wms.demo.repository.ProductoLoteRepository;
import com.wms.demo.repository.ProductoRepository;
import com.wms.demo.repository.ProductoUbicacionLoteRepository;
import com.wms.demo.repository.ProveedorRepository;
import com.wms.demo.repository.UbicacionRepository;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/v1")
public class DashboardController {

	@Autowired
	ProveedorRepository proveedorRepository;

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	UbicacionRepository ubicacionRepository;
	
	@Autowired
	ProductoDetalleRepository productoDetalleRepository;
	
	@Autowired
	ProductoLoteRepository productoLoteRepository;
	
	@Autowired
	ProductoUbicacionLoteRepository productoUbicacionLoteRepository;

	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponseContract> getItems() {
		try {

			// Entidades.Proveedores
			List<Proveedor> proveedores = proveedorRepository.findAll();
			DashboardEntidadContrat entidadProveedoresContract = new DashboardEntidadContrat();
			entidadProveedoresContract.setSvg(
					"M19.428 15.428a2 2 0 00-1.022-.547l-2.387-.477a6 6 0 00-3.86.517l-.318.158a6 6 0 01-3.86.517L6.05 15.21a2 2 0 00-1.806.547M8 4h8l-1 1v5.172a2 2 0 00.586 1.414l5 5c1.26 1.26.367 3.414-1.415 3.414H4.828c-1.782 0-2.674-2.154-1.414-3.414l5-5A2 2 0 009 10.172V5L8 4z");
			entidadProveedoresContract.setNombre("Proveedores");
			entidadProveedoresContract.setCantidad(proveedores.size());
			entidadProveedoresContract.setTexto("Laboratorios fabricantes de las medicinas en venta");
			entidadProveedoresContract.setEnlace("/proveedores");

			// Entidades.Productos
			List<Producto> productos = productoRepository.findAll();
			DashboardEntidadContrat entidadProductosContract = new DashboardEntidadContrat();
			entidadProductosContract.setSvg("M20 7l-8-4-8 4m16 0l-8 4m8-4v10l-8 4m0-10L4 7m8 4v10M4 7v10l8 4");
			entidadProductosContract.setNombre("Productos");
			entidadProductosContract.setCantidad(productos.size());
			entidadProductosContract.setTexto("Medicinas habilitadas para la venta y distribución");
			entidadProductosContract.setEnlace("/productos");

			// Entidades.Ubicaciones
			List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
			DashboardEntidadContrat entidadUbicacionesContract = new DashboardEntidadContrat();
			entidadUbicacionesContract
					.setSvg("M3 10h18M3 14h18m-9-4v8m-7 0h14a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z");
			entidadUbicacionesContract.setNombre("Ubicaciones");
			entidadUbicacionesContract.setCantidad(ubicaciones.size());
			entidadUbicacionesContract.setTexto("Ubicaciones disponibles para el almacenaje de las medicinas");
			entidadUbicacionesContract.setEnlace("/ubicaciones");

			// Entidades
			List<DashboardEntidadContrat> listEntidades = new ArrayList<>(
					Arrays.asList(entidadProveedoresContract, entidadProductosContract, entidadUbicacionesContract));

			// Transaccion.ProductoUbicacionAlmacen
			DashboardTransaccionContract transaccionProductoUbicacionAlmacenContract = new DashboardTransaccionContract();
			transaccionProductoUbicacionAlmacenContract.setSvg(
					"M19 11H5m14 0a2 2 0 012 2v6a2 2 0 01-2 2H5a2 2 0 01-2-2v-6a2 2 0 012-2m14 0V9a2 2 0 00-2-2M5 11V9a2 2 0 012-2m0 0V5a2 2 0 012-2h6a2 2 0 012 2v2M7 7h10");
			transaccionProductoUbicacionAlmacenContract.setNombre("Producto/Ubicación");
			transaccionProductoUbicacionAlmacenContract.setTexto("Listado de Productos con su ubicación de almacenaje");
			transaccionProductoUbicacionAlmacenContract.setEnlace("/productos/ubicaciones");

			// Transaccion.RecepcionProducto
			DashboardTransaccionContract transaccionRecepcionProductoContract = new DashboardTransaccionContract();
			transaccionRecepcionProductoContract.setSvg(
					"M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z");
			transaccionRecepcionProductoContract.setNombre("Recepción de Productos");
			transaccionRecepcionProductoContract.setTexto("Realice una recepción de productos al almacén");
			transaccionRecepcionProductoContract.setEnlace("productos/recepciones");

			// Transaccion.ProductoUbicacionLote
			DashboardTransaccionContract transaccionProductoUbicacionLoteContract = new DashboardTransaccionContract();
			transaccionProductoUbicacionLoteContract.setSvg(
					"M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01");
			transaccionProductoUbicacionLoteContract.setNombre("Inventario de Lotes");
			transaccionProductoUbicacionLoteContract.setTexto("Lotes de productos con su ubicación y cantidad");
			transaccionProductoUbicacionLoteContract.setEnlace("productos/lotes");

			// Transacciones
			List<DashboardTransaccionContract> listTransacciones = new ArrayList<>(Arrays.asList(
					transaccionProductoUbicacionAlmacenContract, transaccionRecepcionProductoContract, transaccionProductoUbicacionLoteContract));

			// Valor Inventario Calc
			DashboardValorInventarioContract valorInventarioContract = new DashboardValorInventarioContract();
			List<ProductoUbicacionLote> productoUbicacionLoteConCantidad = productoUbicacionLoteRepository.findByCantidadGreaterThan(0);

			var totalProductoLoteCosto = 0;
			var totalProductoDetallePrecio = 0;
			var totalUtilidad = 0;
			for (ProductoUbicacionLote productoUbicacionLote : productoUbicacionLoteConCantidad) {
				var productoLote = productoLoteRepository.findById(productoUbicacionLote.getIdLote());
				var productoDetalle = productoDetalleRepository.findByIdProducto(productoUbicacionLote.getIdProducto());

				// Costo Producto Lote
				totalProductoLoteCosto = totalProductoLoteCosto + productoLote.get().getCosto();

				// Precio Producto Detalle (Promediado)
				var precioAcumulado = 0;
				for (int i = 0; i < productoDetalle.size(); i++) {
					precioAcumulado = precioAcumulado + productoDetalle.get(i).getPrecio();
				}
				totalProductoDetallePrecio = totalProductoDetallePrecio + (precioAcumulado / productoDetalle.size());
			}
			// Valor Inventario Sett
			totalUtilidad = totalProductoDetallePrecio - totalProductoLoteCosto;
			valorInventarioContract.setPrecioVenta(totalProductoDetallePrecio);
			valorInventarioContract.setCostoCompra(totalProductoLoteCosto);
			valorInventarioContract.setUtilidad(totalUtilidad);
			
			// Dashboard Items
			DashboardResponseContract responseContract = new DashboardResponseContract();
			responseContract.setEntidades(listEntidades);
			responseContract.setTransacciones(listTransacciones);
			responseContract.setValorInventario(valorInventarioContract);

			return new ResponseEntity<DashboardResponseContract>(responseContract, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
