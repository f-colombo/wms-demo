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
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String descripcion;

	private String tipo;

	private String clase;

	@Column(name = "nivel_rotacion", nullable = false)
	private String nivelRotacion;
	
	@Column(name = "aplica_impuesto", nullable = false)
	private boolean aplicaImpuesto;

	@Column(name = "id_proveedor", nullable = false)
	private Integer idProveedor;
	
	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public Producto() {
	}

	public Producto(String Codigo, String Descripcion, String Tipo, String Clase, String NivelRotacion, boolean AplicaImpuesto, Integer IdProveedor) {
		this.id = 0;
		this.codigo = Codigo;
		this.descripcion = Descripcion;
		this.tipo = Tipo;
		this.clase = Clase;
		this.nivelRotacion = NivelRotacion;
		this.aplicaImpuesto = AplicaImpuesto;
		this.idProveedor = IdProveedor;
		this.createdOn = new Date();
		this.available = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String Codigo) {
		this.codigo = Codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String Descripcion) {
		this.descripcion = Descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String Tipo) {
		this.tipo = Tipo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String Clase) {
		this.clase = Clase;
	}

	public String getNivelRotacion() {
		return nivelRotacion;
	}

	public void setNivelRotacion(String NivelRotacion) {
		this.nivelRotacion = NivelRotacion;
	}
	
	public boolean getAplicaImpuesto() {
		return aplicaImpuesto;
	}

	public void setAplicaImpuesto(boolean AplicaImpuesto) {
		this.aplicaImpuesto = AplicaImpuesto;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer IdProveedor) {
		this.idProveedor = IdProveedor;
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

	@Override
	public String toString() {
		return codigo + " " + descripcion;
	}
	
}
