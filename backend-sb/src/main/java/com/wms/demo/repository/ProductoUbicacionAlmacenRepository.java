package com.wms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.demo.model.ProductoUbicacionAlmacen;

public interface ProductoUbicacionAlmacenRepository extends JpaRepository<ProductoUbicacionAlmacen, Integer> {
	
	public List<ProductoUbicacionAlmacen> findByIdProducto(Integer idProducto);
	
	public List<ProductoUbicacionAlmacen> findByIdUbicacion(Integer idUbicacion);

}