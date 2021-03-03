package com.capirona.springboot.app.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capirona.springboot.app.form.models.domain.Usuario;

@Controller
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Form Usuarios");
		return "form";
	}

	@PostMapping("/form")
	public String procesar(
				Usuario usuario,
				Model model
			) {
		
		model.addAttribute("titulo", "Resultado Form");
		model.addAttribute("usuario", usuario);
		return "resultado";
	}
}
