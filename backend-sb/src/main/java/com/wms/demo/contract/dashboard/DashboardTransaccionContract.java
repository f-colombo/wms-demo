package com.wms.demo.contract.dashboard;

public class DashboardTransaccionContract {
	private String svg;
	private String nombre;
	private String texto;
	private String enlace;

	public DashboardTransaccionContract() {
	}

	public DashboardTransaccionContract(String Svg, String Nombre, String Texto, String Enlace) {
		this.svg = Svg;
		this.nombre = Nombre;
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
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String Texto) {
		this.texto = Texto;
	}

	public String getEnlace() {
		return enlace;
	}

	public void set(String Enlace) {
		this.enlace = Enlace;
	}
	
}
