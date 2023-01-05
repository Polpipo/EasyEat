package com.easyEat.controllers;

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
public class getRestaurantes {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value ={"/restaurantes", "/restaurantes/{nRestaurante}"}, method = RequestMethod.GET)
	public List<mapRestaurantes> getAllRestaurantes(@PathVariable(name =  "nRestaurante") Optional<String> nRestaurante	){
		String queryAllRest = "";
		
		if (nRestaurante.isEmpty() == false) {
			queryAllRest = "SELECT * FROM restaurantes WHERE nRestaurante = \"" + nRestaurante.get() + "\";";
		}else {
			queryAllRest = "SELECT * FROM restaurantes;";
		}
		
		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(queryAllRest);
		
		List<mapRestaurantes> restaurantelList = new ArrayList<mapRestaurantes>();
		
		for (Map<String, Object> fila : resultados) {
			mapRestaurantes restaurante = new mapRestaurantes();
			restaurante.setIdRestaurante(((Integer) fila.get("idRestaurante")).intValue());
			restaurante.setHorario((String)fila.get("horario"));
			restaurante.setnRestaurante((String)fila.get("nRestaurante"));
			restaurante.setDireccion((String)fila.get("direccion"));
			restaurante.setTelefono(((Integer) fila.get("telefono")).intValue());
			restaurante.setnMesas(((Integer) fila.get("nMesas")).intValue());
			restaurante.setUrl((String)fila.get("url"));
			restaurantelList.add(restaurante);
		}
		
		return restaurantelList;
		
	}
}
