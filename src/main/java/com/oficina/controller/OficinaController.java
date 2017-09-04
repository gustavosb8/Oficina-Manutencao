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

import com.oficina.model.Oficina;
import com.oficina.model.Montadora;
import com.oficina.service.OficinaService;
import com.oficina.service.MontadoraService;

@Controller
public class OficinaController {
	
	@Autowired
    private OficinaService service;
	
	@Autowired
	private MontadoraService montadoraService;
	
	@GetMapping("/oficinas")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/oficinas/controleoficina");
        List<Oficina> oficinas = service.findAll();
        System.out.println("***** " + oficinas );
        
		mv.addObject("oficinas", oficinas);
		
        return mv;
    }
	
	@GetMapping("/oficinas/add")
    public ModelAndView add(Oficina oficina) {
         
        ModelAndView mv = new ModelAndView("/oficinas/cadastrooficina");
        mv.addObject("oficina", oficina);
         
        return mv;
    }
	
	@ModelAttribute("MontadorasTodos")
    public List<Montadora> todasManutencoes() {
    	List<Montadora> montadoras = montadoraService.findAll();
    	System.out.println("***** " + montadoras );
		return montadoras;
	}
	
	@GetMapping("/oficinas/edit/{id_oficina}")
    public ModelAndView edit(@PathVariable("id_oficina") Integer id_oficina) {
         
		Oficina oficina = service.findOne(id_oficina);
		
		ModelAndView modelAndView = new ModelAndView("/oficinas/cadastrooficina");
		modelAndView.addObject("oficina", oficina);
		
		return modelAndView;
    }
     
    @GetMapping("/oficinas/delete/{id_oficina}")
    public ModelAndView delete(@PathVariable("id_oficina") Integer id_oficina) {
        service.delete(id_oficina);
        return findAll();
    }
    
    @PostMapping("/oficinas/save")
    public ModelAndView save(@Validated Oficina oficina, Errors validacao, 
    		Integer idMontadora,
    		BindingResult result,
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(Oficina);
            return new ModelAndView("/oficinas/cadastrooficina");
        }
        
        Montadora montadora = montadoraService.findOne(idMontadora);
        service.save(oficina, montadora);
        
        ModelAndView mv = new ModelAndView("redirect:/oficinas/add");
        redirect.addFlashAttribute("mensagem_sucesso", "A oficina ["+oficina.getDescricaoOficina()+"] foi Salva com Sucesso" );

        return mv;
    }
}
