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
@Table(name = "producto_ubicacion_lote")
public class ProductoUbicacionLote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;

	@Column(name = "id_ubicacion", nullable = false)
	private Integer idUbicacion;
	
	@Column(name = "id_lote", nullable = false)
	private Integer idLote;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "cantidad_bloqueada", nullable = false)
	private Integer cantidadBloqueada;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public ProductoUbicacionLote() {
	}
	
	public ProductoUbicacionLote(Integer IdProducto, Integer IdUbicacion, Integer IdLote, Integer Cantidad, Integer CantidadBloqueada) {
		this.id = 0;
		this.idProducto = IdProducto;
		this.idUbicacion = IdUbicacion;
		this.idLote = IdLote;
		this.cantidad = Cantidad;
		this.cantidadBloqueada = CantidadBloqueada;
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

	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer IdLote) {
		this.idLote = IdLote;
	}


	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer Cantidad) {
		this.cantidad = Cantidad;
	}

	public Integer getCantidadBloqueada() {
		return cantidadBloqueada;
	}

	public void setCantidadBloqueada(Integer CantidadBloqueada) {
		this.cantidadBloqueada = CantidadBloqueada;
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
