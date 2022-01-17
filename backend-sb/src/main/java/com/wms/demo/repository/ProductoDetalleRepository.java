package com.wms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.demo.model.ProductoDetalle;

public interface ProductoDetalleRepository extends JpaRepository<ProductoDetalle, Integer> {

	public List<ProductoDetalle> findByIdProducto(Integer idProducto);

}
