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
import com.wms.demo.model.Proveedor;
import com.wms.demo.repository.ProveedorRepository;

@WebMvcTest(ProveedorController.class)
public class ProveedorControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	ProveedorRepository proveedorRepository;

	Proveedor PROV_01 = new Proveedor("PFBI", "Pfizer-BioNTech", "Dir 1", "info@prov1.com", "2 01000000");
	Proveedor PROV_02 = new Proveedor("OXAS", "Oxford/AstraZeneca", "Dir 2", "info@prov2.com", "2 03000000");
	Proveedor PROV_03 = new Proveedor("SPHA", "Sinopharm", "Dir 3", "info@prov3.com", "2 03000000");

	@Test
	public void context_loads() throws Exception {
		assertThat(proveedorRepository).isNotNull();
	}

	@Test
	public void getAll_success() throws Exception {
		List<Proveedor> list = new ArrayList<>(Arrays.asList(PROV_01, PROV_02, PROV_03));
		// System.out.println(list);
		Mockito.when(proveedorRepository.findAll()).thenReturn(list);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/proveedores").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(3)))
				.andExpect(jsonPath("$[2].codigo", is("SPHA")));
	}

	@Test
	public void getSingle_success() throws Exception {
		PROV_01.setId(1);
		Mockito.when(proveedorRepository.findById(PROV_01.getId())).thenReturn(java.util.Optional.of(PROV_01));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/proveedores/1").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.nombre", is("Pfizer-BioNTech")));
	}
}
