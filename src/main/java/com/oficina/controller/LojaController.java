package com.oficina.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.model.Loja;
import com.oficina.model.Montadora;
import com.oficina.service.LojaService;
import com.oficina.service.MontadoraService;

@Controller
public class LojaController {

	@Autowired
    private LojaService service;
	
	@Autowired
	private MontadoraService montadoraService;
	
	@GetMapping("/lojas")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/lojas/controleloja");
        List<Loja> lojas = service.findAll();
        System.out.println("***** " + lojas );
        
		mv.addObject("lojas", lojas);
		
        return mv;
    }
	
	@GetMapping("/lojas/add")
    public ModelAndView add(Loja loja) {
         
        ModelAndView mv = new ModelAndView("/lojas/cadastroloja");
        mv.addObject("lojas", loja);
         
        return mv;
    }
	
	@ModelAttribute("MontadorasTodos")
    public List<Montadora> todasMontadoras() {
    	List<Montadora> montadoras = montadoraService.findAll();
    	System.out.println("***** " + montadoras );
		return montadoras;
	}
	
	@GetMapping("/lojas/edit/{id_loja}")
    public ModelAndView edit(@PathVariable("id_loja") Integer id_loja) {
         
    	Loja loja = service.findOne(id_loja);
		
		ModelAndView modelAndView = new ModelAndView("/lojas/cadastroloja");
		modelAndView.addObject("loja", loja);
		
		return modelAndView;
    }
     
    @GetMapping("/lojas/delete/{id_loja}")
    public ModelAndView delete(@PathVariable("id_loja") Integer id_loja) {
        service.delete(id_loja);
        return findAll();
    }
    
    @PostMapping("/lojas/save")
    public ModelAndView save(@Validated Loja loja, Errors validacao, 
    		Integer idMontadora,
    		BindingResult result,
    		 
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(loja);
            return new ModelAndView("/lojas/cadastroloja");
        }
        
        
        Montadora montadora = montadoraService.findOne(idMontadora);
        service.save(loja, montadora);
        
        ModelAndView mv = new ModelAndView("redirect:/lojas/add");
        redirect.addFlashAttribute("mensagem_sucesso", "A loja ["+loja.getNomeLoja()+"] foi Salva com Sucesso" );

        return mv;
    }
}
