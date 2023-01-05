package com.easyEat.controllers;

import java.io.Serializable;

public class mapRestaurantes implements Serializable {
	private static final long serialVersionUID = 1;
	
	private int idRestaurante;
	private String horario;
	private String nRestaurante;
	private String direccion;
	private int telefono;
	private int nMesas;
	private String url;
	
	public mapRestaurantes() {}

	public mapRestaurantes(int idRestaurante, String horario, String nRestaurante, String direccion, int telefono,
		int nMesas, String url) {
		super();
		this.idRestaurante = idRestaurante;
		this.horario = horario;
		this.nRestaurante = nRestaurante;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nMesas = nMesas;
		this.url = url;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getnRestaurante() {
		return nRestaurante;
	}

	public void setnRestaurante(String nRestaurante) {
		this.nRestaurante = nRestaurante;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getnMesas() {
		return nMesas;
	}

	public void setnMesas(int nMesas) {
		this.nMesas = nMesas;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}
