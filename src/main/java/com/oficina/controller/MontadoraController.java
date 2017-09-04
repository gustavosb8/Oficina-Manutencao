package com.oficina.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.model.Montadora;
import com.oficina.service.MontadoraService;

@Controller
public class MontadoraController {

	@Autowired
    private MontadoraService service;
	
	@GetMapping("/montadoras")
    public ModelAndView findAll() {
		
        ModelAndView mv = new ModelAndView("/montadoras/controlemontadora");
        List<Montadora> montadoras = service.findAll();
        System.out.println("***** " + montadoras );
        
		mv.addObject("montadoras", montadoras);
		
        return mv;
    }
	
	@GetMapping("/montadoras/add")
    public ModelAndView add(Montadora montadora) {
         
        ModelAndView mv = new ModelAndView("/montadoras/cadastromontadora");
        mv.addObject("montadoras", montadora);
         
        return mv;
    }
	
	@GetMapping("/montadoras/edit/{id_montadora}")
    public ModelAndView edit(@PathVariable("id_montadora") Integer id_montadora) {
         
    	Montadora montadora = service.findOne(id_montadora);
		
		ModelAndView modelAndView = new ModelAndView("/montadoras/cadastromontadora");
		modelAndView.addObject("montadora", montadora);
		
		return modelAndView;
    }
     
    @GetMapping("/montadoras/delete/{id_montadora}")
    public ModelAndView delete(@PathVariable("id_montadora") Integer id_montadora) {
        service.delete(id_montadora);
        return findAll();
    }
    
    @PostMapping("/montadoras/save")
    public ModelAndView save(@Validated Montadora montadora, Errors validacao, 
    		BindingResult result,
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(montadora);
            return new ModelAndView("/montadoras/cadastromontadora");
        }

        service.save(montadora);
        
        ModelAndView mv = new ModelAndView("redirect:/montadoras/add");
        redirect.addFlashAttribute("mensagem_sucesso", "Montadora ["+montadora.getDescricaoMontadora()+"] Salvo com Sucesso" );

        return mv;
    }
}
