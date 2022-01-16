package com.wms.demo.contract.dashboard;

public class DashboardValorInventarioContract {
	private Integer precioVenta;
	private Integer costoCompra;
	private Integer utilidad;
	
	public DashboardValorInventarioContract() {
	}

	public DashboardValorInventarioContract(Integer PrecioVenta, Integer CostoCompra, Integer Utilidad) {
		this.precioVenta = PrecioVenta;
		this.costoCompra = CostoCompra;
		this.utilidad = Utilidad;
	}
	
	public Integer getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Integer PrecioVenta) {
		this.precioVenta = PrecioVenta;
	}
	
	public Integer getCostoCompra() {
		return costoCompra;
	}

	public void setCostoCompra(Integer CostoCompra) {
		this.costoCompra = CostoCompra;
	}
	
	public Integer getUtilidad() {
		return utilidad;
	}

	public void setUtilidad(Integer Utilidad) {
		this.utilidad = Utilidad;
	}
	
}
