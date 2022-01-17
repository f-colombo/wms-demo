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
@Table(name = "producto_detalle")
public class ProductoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;

	private Integer precio;

	private Integer descuento;

	private Integer costo;

	private Integer peso;

	private Integer volumen;

	private Integer cantidad;

	@Column(name = "aplica_descuento", nullable = false)
	private boolean aplicaDescuento;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public ProductoDetalle() {

	}

	public ProductoDetalle(Integer IdProducto, Integer Precio, Integer Descuento, Integer Costo, Integer Peso,
			Integer Volumen, Integer Cantidad, boolean AplicaDescuento) {
		this.id = 0;
		this.idProducto = IdProducto;
		this.precio = Precio;
		this.descuento = Descuento;
		this.costo = Costo;
		this.peso = Peso;
		this.volumen = Volumen;
		this.cantidad = Cantidad;
		this.aplicaDescuento = AplicaDescuento;
		this.createdOn = new Date();
		this.available = true;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer IdProducto) {
		this.idProducto = IdProducto;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer Precio) {
		this.precio = Precio;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer Descuento) {
		this.descuento = Descuento;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer Costo) {
		this.costo = Costo;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer Peso) {
		this.peso = Peso;
	}

	public Integer getVolumen() {
		return volumen;
	}

	public void setVolumen(Integer Volumen) {
		this.volumen = Volumen;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer Cantidad) {
		this.cantidad = Cantidad;
	}
	
	public boolean getAplicaDescuento() {
		return aplicaDescuento;
	}

	public void setAplicaDescuento(boolean AplicaDescuento) {
		this.aplicaDescuento = AplicaDescuento;
	}

}
