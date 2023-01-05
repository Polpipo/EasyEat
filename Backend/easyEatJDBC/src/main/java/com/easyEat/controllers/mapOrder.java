package com.easyEat.controllers;

import java.io.Serializable;

public class mapOrder implements Serializable{
	private static final long serialVersionUID = 1;
	
	private int id;

	public mapOrder() {
		
	}

	public mapOrder(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	
}
