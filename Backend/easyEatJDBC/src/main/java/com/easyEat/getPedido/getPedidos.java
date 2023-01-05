package com.easyEat.getPedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class getPedidos {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value ={"/getPedidos/{nPedido}"}, method = RequestMethod.GET)
	public List<mapPedido> getPedido(@PathVariable(name =  "nPedido") Optional<String> nPedido){
		String querString = "SELECT nComida, cantidadPlato FROM pedido WHERE Orders_idOrder = " + nPedido.get() + ";";
		
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(querString);

		List<mapPedido> pedidos = new ArrayList<mapPedido>();
		
		for (Map<String, Object> fila : resultados) {
			mapPedido pedido = new mapPedido();
			pedido.setnComida((String)fila.get("nComida"));
			pedido.setCantidadPlato((String) fila.get("cantidadPlato"));

			pedidos.add(pedido);
		}

		
		return pedidos;
		
		
	}
}
