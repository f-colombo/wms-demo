package com.wms.demo.model;

import java.security.Timestamp;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "producto_ubicacion_almacen")
public class ProductoUbicacionAlmacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;

	@Column(name = "id_ubicacion", nullable = false)
	private Integer idUbicacion;
	
	private String clasificacion;
	
	@Column(name = "cantidad_maxima", nullable = false)
	private Integer cantidadMaxima;
	
	@Column(name = "cantidad_minima", nullable = false)
	private Integer cantidadMinima;

	@Column(name = "orden_recorrido", nullable = false)
	private Integer ordenRecorrido;
	
	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public ProductoUbicacionAlmacen() {
	}
	
	public ProductoUbicacionAlmacen(Integer IdProducto, Integer IdUbicacion, String Clasificacion, Integer CantidadMaxima, Integer CantidadMinima, Integer OrdenRecorrido) {
		this.id = 0;
		this.idProducto = IdProducto;
		this.idUbicacion = IdUbicacion;
		this.clasificacion = Clasificacion;
		this.cantidadMaxima = CantidadMaxima;
		this.cantidadMinima = CantidadMinima;
		this.ordenRecorrido = OrdenRecorrido;
		this.createdOn = new Date();
		this.available = true;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer IdProducto) {
		this.idProducto = IdProducto;
	}

	public Integer getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Integer IdUbicacion) {
		this.idUbicacion = IdUbicacion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String Clasificacion) {
		this.clasificacion = Clasificacion;
	}

	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer CantidadMaxima) {
		this.cantidadMaxima = CantidadMaxima;
	}

	public Integer getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(Integer CantidadMinima) {
		this.cantidadMinima = CantidadMinima;
	}
	
	public Integer getOrdenRecorrido() {
		return ordenRecorrido;
	}

	public void setOrdenRecorrido(Integer OrdenRecorrido) {
		this.ordenRecorrido = OrdenRecorrido;
	}

	public Date getCreateOn() {
		return createdOn;
	}

	public void setCreateOn(Date CreateOn) {
		this.createdOn = CreateOn;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean Available) {
		this.available = Available;
	}
	
}
