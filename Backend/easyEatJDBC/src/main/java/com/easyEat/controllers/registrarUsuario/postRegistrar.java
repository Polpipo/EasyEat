package com.easyEat.controllers.registrarUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class postRegistrar {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@CrossOrigin(origins = "*")
	@PostMapping(value = { "/usuario/registrar" })
	public int registrarUser(@RequestParam String nameSurname, String nUsuario, String email, String phone,
			String passwd) {
			if (nameSurname == "" || nUsuario == "" || email == "" || phone == "" || passwd == "") {
				return 0;
			}else {
				String query = "INSERT INTO usuarios VALUES(null, \"" + nameSurname + "\",\"" + nUsuario + "\",\"" + email + "\",\"" + phone + "\",\"" + passwd+ "\");";
				jdbcTemplate.execute(query);
			}
		return 1;
	}

	@GetMapping("/registrar2")
	private ModelAndView mostrarView() {
		ModelAndView modelAndView = new ModelAndView("index.html");
		
		return modelAndView;
	}

}
