package com.oficina.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String logarNoSistema() {
		
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView logado() {
		ModelAndView mv = new ModelAndView("veiculos/controleveiculo");
		return mv;
	}
}