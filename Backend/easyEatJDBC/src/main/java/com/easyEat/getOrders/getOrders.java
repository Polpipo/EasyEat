package com.easyEat.getOrders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class getOrders {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value ={"/getOrders"}, method = RequestMethod.GET)
	public List<mapOrders> getOrdenes(){
		
		String queryString = "SELECT idOrder, orderDate, pagado, Restaurantes_idRestaurante from orders WHERE orderDate = current_date() AND Restaurantes_idRestaurante = 2;";
		
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(queryString);
		
		List<mapOrders> ordersList = new ArrayList<mapOrders>();
		
		for (Map<String, Object> fila : resultados) {
			mapOrders ordenes = new mapOrders();
			ordenes.setIdOrder(((Integer) fila.get("idOrder")).intValue());
			ordenes.setOrderDate((Date) fila.get("orderDate"));
			if ((int) fila.get("pagado") == 1) {
				ordenes.setPagado("Pagado");
			}else {
				ordenes.setPagado("No pagado");
			}
			ordenes.setIdRest(((Integer) fila.get("Restaurantes_idRestaurante")).intValue());
			ordersList.add(ordenes);
		}
		
	return ordersList;

	}
}
