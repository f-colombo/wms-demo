package com.wms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.demo.model.ProductoLote;

public interface ProductoLoteRepository extends JpaRepository<ProductoLote, Integer> {
	
	public List<ProductoLote> findByIdProducto(Integer idProducto);

}
