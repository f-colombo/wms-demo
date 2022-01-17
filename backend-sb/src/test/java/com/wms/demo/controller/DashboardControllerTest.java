package com.wms.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wms.demo.model.Producto;
import com.wms.demo.model.ProductoDetalle;
import com.wms.demo.model.ProductoLote;
import com.wms.demo.model.ProductoUbicacionLote;
import com.wms.demo.model.Proveedor;
import com.wms.demo.model.Ubicacion;
import com.wms.demo.repository.ProductoDetalleRepository;
import com.wms.demo.repository.ProductoLoteRepository;
import com.wms.demo.repository.ProductoRepository;
import com.wms.demo.repository.ProductoUbicacionLoteRepository;
import com.wms.demo.repository.ProveedorRepository;
import com.wms.demo.repository.UbicacionRepository;

@WebMvcTest(DashboardController.class)
public class DashboardControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	ProveedorRepository proveedorRepository;

	@MockBean
	ProductoRepository productoRepository;

	@MockBean
	UbicacionRepository ubicacionRepository;

	@MockBean
	ProductoDetalleRepository productoDetalleRepository;

	@MockBean
	ProductoLoteRepository productoLoteRepository;

	@MockBean
	ProductoUbicacionLoteRepository productoUbicacionLoteRepository;

	Proveedor PROV_01 = new Proveedor("PFBI", "Pfizer-BioNTech", "Dir 1", "info@prov1.com", "2 01000000");
	Proveedor PROV_02 = new Proveedor("OXAS", "Oxford/AstraZeneca", "Dir 2", "info@prov2.com", "2 03000000");
	Proveedor PROV_03 = new Proveedor("SPHA", "Sinopharm", "Dir 3", "info@prov3.com", "2 03000000");

	Producto PROD_01 = new Producto("COD01", "DESC01", "TIP01", "CLAS01", "A", false, 0);
	Producto PROD_02 = new Producto("COD02", "DESC02", "TIP02", "CLAS02", "B", false, 0);
	Producto PROD_03 = new Producto("COD03", "DESC03", "TIP03", "CLAS03", "C", false, 0);
	
	Ubicacion UBIC_01 = new Ubicacion("001", "A", "001", "TIP01");
	Ubicacion UBIC_02 = new Ubicacion("001", "B", "001", "TIP02");
	Ubicacion UBIC_03 = new Ubicacion("001", "C", "001", "TIP02");
	
	ProductoDetalle PDET_01 = new ProductoDetalle(0, 1000, 100, 800, 10, 35, 10, false);
	ProductoDetalle PDET_02 = new ProductoDetalle(0, 1000, 100, 800, 10, 35, 10, false);
	ProductoDetalle PDET_03 = new ProductoDetalle(0, 1000, 100, 800, 10, 35, 10, false);
	
	Optional<ProductoLote> PLOT_01 = Optional.ofNullable(new ProductoLote(0,"10ND","05/2022","790909090090000",1000,800,10,0,10,2,10,10,10,23));
	
	ProductoUbicacionLote PULT_01 = new ProductoUbicacionLote(1, 1, 1, 10, 0);
	ProductoUbicacionLote PULT_02 = new ProductoUbicacionLote(2, 2, 2, 10, 0);
	ProductoUbicacionLote PULT_03 = new ProductoUbicacionLote(3, 3, 3, 10, 0);
	
	@Test
	public void context_loads() throws Exception {
		assertThat(proveedorRepository).isNotNull();
		assertThat(productoRepository).isNotNull();
		assertThat(ubicacionRepository).isNotNull();
		assertThat(productoDetalleRepository).isNotNull();
		assertThat(productoLoteRepository).isNotNull();
		assertThat(productoUbicacionLoteRepository).isNotNull();
	}

	@Test
	public void getItems_error() throws Exception {
		List<Proveedor> listProveedor = new ArrayList<>(Arrays.asList(PROV_01, PROV_02, PROV_03));
		List<Producto> listProducto = new ArrayList<>(Arrays.asList(PROD_01, PROD_02, PROD_03));
		List<Ubicacion> listUbicacion = new ArrayList<>(Arrays.asList(UBIC_01, UBIC_02, UBIC_03));
		List<ProductoDetalle> listProductoDetalle = new ArrayList<>(Arrays.asList(PDET_01, PDET_02, PDET_03));
		List<ProductoUbicacionLote> listProductoUbicacionLote = new ArrayList<>(Arrays.asList(PULT_01, PULT_02, PULT_03));
		
		Mockito.when(proveedorRepository.findAll()).thenReturn(listProveedor);
		Mockito.when(productoRepository.findAll()).thenReturn(listProducto);
		Mockito.when(ubicacionRepository.findAll()).thenReturn(listUbicacion);
		Mockito.when(productoDetalleRepository.findByIdProducto(0)).thenReturn(listProductoDetalle);
		Mockito.when(productoLoteRepository.findById(0)).thenReturn(PLOT_01);
		Mockito.when(productoUbicacionLoteRepository.findByCantidadGreaterThan(0)).thenReturn(listProductoUbicacionLote);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/dashboard").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().is5xxServerError());
//				.andExpect(jsonPath("$", Matchers.hasSize(3)))
//				.andExpect(jsonPath("$[2].codigo", is("SPHA")));
	}

}
