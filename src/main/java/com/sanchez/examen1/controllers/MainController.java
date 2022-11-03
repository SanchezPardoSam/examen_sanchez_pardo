package com.sanchez.examen1.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class MainController {
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}

	@GetMapping("/tareas")
	public String getCategorias(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("usuario", auth.getName());
		return "tareas";
	}
}
