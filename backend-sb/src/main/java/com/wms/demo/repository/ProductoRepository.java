package com.wms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	public List<Producto> findByIdProveedor(Integer idProveedor);

}