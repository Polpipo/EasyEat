package com.easyEat.controllers.registrarMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easyEat.controllers.mapOrder;

@RestController
public class postMenu {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private int idAutoIncrement;
	private String idRestaurante;
	private int returnInt;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = {"/menu/registrar"})
	public int registrarMenu(@RequestParam Map<String, String> allParams) {
	
	for (Map.Entry<String, String> entry : allParams.entrySet()) {
		String key = entry.getKey();
		idRestaurante = (String) key.subSequence(key.length()-1, key.length());
	}
	
	boolean isNull = true;
	
	for (Map.Entry<String, String> entry : allParams.entrySet()) {
		String val = entry.getValue();
		if (val.equals("0")) {
		}else {
			isNull = false;
			break;
		}
	}
	
	if (isNull) {
		returnInt = 0 ;
	}else {
	String query = "INSERT INTO pedido values (null, ";
	
	String queryCreateOrder = "INSERT INTO orders values (null, current_date(), null, true, \"" + idRestaurante + "\");";
	
	jdbcTemplate.execute(queryCreateOrder);
	
	try {
		String subQuery = "SELECT idOrder FROM orders ORDER BY idOrder DESC;";
		
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(subQuery);
		List<mapOrder> ordenes = new ArrayList<mapOrder>();
		
		idAutoIncrement = (int) resultados.get(0).get("idOrder");
		
		returnInt = idAutoIncrement ;
		
		for (Map<String, Object> fila : resultados) {
			mapOrder orden = new mapOrder();
			orden.setId(((Integer) fila.get("idOrder")).intValue());
			ordenes.add(orden);
		}
		
	} catch (Exception e) {
		System.out.println(e);
	}
	//INSERTAR PEDIDOS EN TABLA pedidos
	for (Map.Entry<String, String> entry : allParams.entrySet()) {
		String key = entry.getKey();
		key = key.substring(0, key.length()-1);
		String val = entry.getValue();
		if (val.equals("0")) {
		}else {
			query = "INSERT INTO pedido values (null, ";
			query += "\"" + key + "\", \"" + val + "\", null, " + idAutoIncrement ;
			query += ");";
			jdbcTemplate.execute(query);
		}
		
	}
}
	return returnInt;
	}
}
