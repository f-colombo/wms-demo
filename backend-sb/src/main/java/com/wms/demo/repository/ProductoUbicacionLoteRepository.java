package com.wms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.demo.model.ProductoUbicacionLote;

public interface ProductoUbicacionLoteRepository extends JpaRepository<ProductoUbicacionLote, Integer> {
	
	public List<ProductoUbicacionLote> findByIdProducto(Integer idProducto);
	
	public List<ProductoUbicacionLote> findByIdUbicacion(Integer idUbicacion);
	
	public List<ProductoUbicacionLote> findByIdLote(Integer idLote);

}
