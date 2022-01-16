package com.wms.demo.contract.dashboard;

import java.util.List;

public class DashboardResponseContract {
	List<DashboardEntidadContrat> entidades;
	List<DashboardTransaccionContract> transacciones;
	DashboardValorInventarioContract valorInventario;
	
	public DashboardResponseContract() {
	}

	public DashboardResponseContract(List<DashboardEntidadContrat> Entidades, List<DashboardTransaccionContract> Transacciones, DashboardValorInventarioContract ValorInventario) {
		this.entidades = Entidades;
		this.transacciones = Transacciones;
		this.valorInventario = ValorInventario;
	}
	
	public List<DashboardEntidadContrat> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<DashboardEntidadContrat> Entidades) {
		this.entidades = Entidades;
	}
	
	public List<DashboardTransaccionContract> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<DashboardTransaccionContract> Transacciones) {
		this.transacciones = Transacciones;
	}
	
	public DashboardValorInventarioContract getValorInventario() {
		return valorInventario;
	}

	public void setValorInventario(DashboardValorInventarioContract ValorInventario) {
		this.valorInventario = ValorInventario;
	}
}
