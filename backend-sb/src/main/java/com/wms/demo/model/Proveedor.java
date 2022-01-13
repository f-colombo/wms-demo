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
		this.codigo = Codigo;
		this.nombre = Nombre;
		this.direccion = Direccion;
		this.email = Email;
		this.telefono = Telefono;
	}
	
	public int getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	@Override
	public String toString() {
		return codigo + " " + nombre;
	}

}
