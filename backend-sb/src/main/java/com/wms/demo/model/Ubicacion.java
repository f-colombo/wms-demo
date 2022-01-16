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
@Table(name = "ubicacion")
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String codigo;

	private String nivel;

	private String segmento;

	@Column(name = "codigo_tipo", nullable = false)
	private String codigoTipo;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	private boolean available;

	public Ubicacion() {
	}

	public Ubicacion(String Codigo, String Nivel, String Segmento, String CodigoTipo) {
		this.id = 0;
		this.codigo = Codigo;
		this.nivel = Nivel;
		this.segmento = Segmento;
		this.codigoTipo = CodigoTipo;
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String Nivel) {
		this.nivel = Nivel;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String Segmento) {
		this.segmento = Segmento;
	}

	public String getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(String CodigoTipo) {
		this.codigoTipo = CodigoTipo;
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
		return codigoTipo + codigo + nivel + segmento;
	}
	
}
