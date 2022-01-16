package com.wms.demo.contract.dashboard;

import java.util.Date;

public class DashboardEntidadContrat {
	private String svg;
	private String nombre;
	private Integer cantidad;
	private String texto;
	private String enlace;

	public DashboardEntidadContrat() {
	}

	public DashboardEntidadContrat(String Svg, String Nombre, Integer Cantidad, String Texto, String Enlace) {
		this.svg = Svg;
		this.nombre = Nombre;
		this.cantidad = Cantidad;
		this.texto = Texto;
		this.enlace = Enlace;
	}
	
	public String getSvg() {
		return svg;
	}

	public void setSvg(String Svg) {
		this.svg = Svg;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String Nombre) {
		this.nombre = Nombre;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer Cantidad) {
		this.cantidad = Cantidad;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String Texto) {
		this.texto = Texto;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String Enlace) {
		this.enlace = Enlace;
	}
	
}
