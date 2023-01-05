package com.easyEat.controllers;

import java.io.Serializable;

public class mapMenu implements Serializable {
	private static final long serialVersionUID = 1;
	
	private int idRestaurante;
	private String nPlato;
	private String precioComida;
	private String tComida;
	private String url;
	
	public mapMenu() {}

	public mapMenu(int idRestaurante, String nPlato, String precioComida, String tComida, String url) {
		super();
		this.idRestaurante = idRestaurante;
		this.nPlato = nPlato;
		this.precioComida = precioComida;
		this.tComida = tComida;
		this.url = url;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getnPlato() {
		return nPlato;
	}

	public void setnPlato(String nPlato) {
		this.nPlato = nPlato;
	}

	public String getPrecioComida() {
		return precioComida;
	}

	public void setPrecioComida(String precioComida) {
		this.precioComida = precioComida;
	}

	public String gettComida() {
		return tComida;
	}

	public void settComida(String tComida) {
		this.tComida = tComida;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}

