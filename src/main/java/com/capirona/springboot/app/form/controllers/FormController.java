package com.capirona.springboot.app.form.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.capirona.springboot.app.form.models.domain.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jhon");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.465.845-H");
		model.addAttribute("titulo", "Formulario Usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result,Model model, SessionStatus status) {
		model.addAttribute("titulo", "Resultado Formulario Usuarios");
		if(result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
