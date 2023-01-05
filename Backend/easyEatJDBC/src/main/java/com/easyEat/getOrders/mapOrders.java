package com.easyEat.getOrders;

import java.io.Serializable;
import java.sql.Date;

public class mapOrders implements Serializable{
	private static final long serialVersionUID = 1;
	
	private int idOrder;
	private Date orderDate;
	private String pagado;
	private int idRest;
	
	public mapOrders() {}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String string) {
		this.pagado = string;
	}

	public int getIdRest() {
		return idRest;
	}

	public void setIdRest(int idRest) {
		this.idRest = idRest;
	}

	public mapOrders(int idOrder, Date orderDate, String pagado, int idRest) {
		super();
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.pagado = pagado;
		this.idRest = idRest;
	}
	
	

}
