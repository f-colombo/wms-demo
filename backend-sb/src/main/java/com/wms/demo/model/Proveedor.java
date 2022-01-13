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
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String nombre;

	private String direccion;

	private String email;

	private String telefono;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public Proveedor() {
	}

	public Proveedor(String Codigo, String Nombre, String Direccion, String Email, String Telefono) {
		this.id = 0;
		this.codigo = Codigo;
		this.nombre = Nombre;
		this.direccion = Direccion;
		this.email = Email;
		this.telefono = Telefono;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String Direccion) {
		this.direccion = Direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String Telefono) {
		this.telefono = Telefono;
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
		return codigo + " " + nombre;
	}

}
