package com.easyEat.getPedido;

import java.io.Serializable;

public class mapPedido implements Serializable{
	private static final long serialVersionUID = 1;
	
	private String nComida;
	private String cantidadPlato;
	
	public mapPedido() {}

	public String getnComida() {
		return nComida;
	}

	public void setnComida(String nComida) {
		this.nComida = nComida;
	}

	public String getCantidadPlato() {
		return cantidadPlato;
	}

	public void setCantidadPlato(String cantidadPlato) {
		this.cantidadPlato = cantidadPlato;
	}

	public mapPedido(String nComida, String cantidadPlato) {
		super();
		this.nComida = nComida;
		this.cantidadPlato = cantidadPlato;
	}
}
