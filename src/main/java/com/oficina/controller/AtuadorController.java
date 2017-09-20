package com.oficina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AtuadorController {
	
	@GetMapping("/atuador")
    public ModelAndView getAtuador() {
         
        ModelAndView mv = new ModelAndView("atuador/atuador");

        
        return mv;
    }
}
