package com.wms.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "producto_lote")
public class ProductoLote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_producto", nullable = false)
	private Integer idProducto;

	private String serie;

	@Column(name = "fecha_expiracion", nullable = false)
	private String fechaExpiracion;

	@Column(name = "codigo_barra", nullable = false)
	private String codigoBarra;

	private Integer precio;

	private Integer costo;

	private Integer cantidad;

	@Column(name = "cantidad_bloqueada", nullable = false)
	private Integer cantidadBloqueada;

	private Integer original;
	private Integer innerpack;
	private Integer largo;
	private Integer ancho;
	private Integer alto;
	private Integer peso;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public ProductoLote() {
	}

	public ProductoLote(Integer IdProducto, String Serie, String FechaExpiracion, String CodigoBarra, Integer Precio,
			Integer Costo, Integer Cantidad, Integer CantidadBloqueada, Integer Original, Integer InnerPack,
			Integer Largo, Integer Ancho, Integer Alto, Integer Peso) {
		this.id = 0;
		this.idProducto = IdProducto;
		this.serie = Serie;
		this.fechaExpiracion = FechaExpiracion;
		this.codigoBarra = CodigoBarra;
		this.precio = Precio;
		this.costo = Costo;
		this.cantidad = Cantidad;
		this.cantidadBloqueada = CantidadBloqueada;
		this.original = Original;
		this.innerpack = InnerPack;
		this.largo = Largo;
		this.ancho = Ancho;
		this.alto = Alto;
		this.peso = Peso;
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

	public String getSerie() {
		return serie;
	}

	public void setSerie(String Serie) {
		this.serie = Serie;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String FechaExpiracion) {
		this.fechaExpiracion = FechaExpiracion;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String CodigoBarra) {
		this.codigoBarra = CodigoBarra;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer Precio) {
		this.precio = Precio;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer Costo) {
		this.costo = Costo;
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

	public Integer getOriginal() {
		return original;
	}

	public void setOriginal(Integer Original) {
		this.original = Original;
	}

	public Integer getInnerpack() {
		return innerpack;
	}

	public void setInnerpack(Integer Innerpack) {
		this.innerpack = Innerpack;
	}

	public Integer getLargo() {
		return largo;
	}

	public void setLargo(Integer Largo) {
		this.largo = Largo;
	}

	public Integer getAncho() {
		return ancho;
	}

	public void setAncho(Integer Ancho) {
		this.ancho = Ancho;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer Alto) {
		this.alto = Alto;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer Peso) {
		this.peso = Peso;
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
