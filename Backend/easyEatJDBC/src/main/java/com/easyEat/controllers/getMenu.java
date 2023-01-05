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
public class getMenu {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/menu/{nRestaurante}/{nMesa}", method = RequestMethod.GET)
	public List<mapMenu> getAllRestaurantes(@PathVariable(name = "nRestaurante") Optional<String> nRestaurante,
			@PathVariable("nMesa") Optional<String> nMesa) {
		String queryAllRest = "";

		queryAllRest = "SELECT idRestaurante FROM restaurantes WHERE nRestaurante = \"" + nRestaurante.get() + "\";";

		List<Map<String, Object>> resultados = jdbcTemplate.queryForList(queryAllRest);

		String identificador = resultados.toString();

		identificador = (String) identificador.subSequence(identificador.indexOf("=") + 1, identificador.indexOf("}"));

		queryAllRest = "SELECT * FROM menu WHERE Restaurantes_idRestaurante = \"" + identificador + "\";";

		resultados.clear();

		resultados = jdbcTemplate.queryForList(queryAllRest);

		List<mapMenu> menuList = new ArrayList<mapMenu>();

		for (Map<String, Object> fila : resultados) {
			mapMenu menu = new mapMenu();
			menu.setIdRestaurante(((Integer) fila.get("Restaurantes_idRestaurante")).intValue());
			menu.setnPlato((String) fila.get("nPlato"));
			menu.setPrecioComida((String) fila.get("precioComida"));
			menu.settComida((String) fila.get("tComida"));
			menu.setUrl((String) fila.get("url"));

			menuList.add(menu);
		}

		return menuList;

	}

}
