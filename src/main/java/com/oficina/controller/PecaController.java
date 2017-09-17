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

import com.oficina.model.Fabricante;
import com.oficina.model.Peca;
import com.oficina.service.FabricanteService;
import com.oficina.service.PecaService;

@Controller
public class PecaController {

	@Autowired
    private PecaService service;
	
	@Autowired
    private FabricanteService fabricanteService;
	
    @GetMapping("/pecas")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/pecas/controlepeca");
        List<Peca> pecas = service.findAll();
        /*System.out.println("***** " + pecas );*/
        
		mv.addObject("pecas", pecas);

        return mv;
    }
     

    @GetMapping("/pecas/add")
    public ModelAndView add(Peca peca) {
 
        ModelAndView mv = new ModelAndView("/pecas/cadastropeca");
        mv.addObject("peca", peca);

        return mv;
    }
    
    @ModelAttribute("FabricanteTodos")
    public List<Fabricante> todasFabricantes() {
    	List<Fabricante> fabricantes = fabricanteService.findAll();
    	System.out.println("***** " + fabricantes );
		return fabricantes;
	}
     
    @GetMapping("/pecas/edit/{id_peca}")
    public ModelAndView edit(@PathVariable("id_peca") Integer id_peca) {
         
    	Peca peca = service.findOne(id_peca );
		
		ModelAndView modelAndView = new ModelAndView("/pecas/cadastropeca");
		modelAndView.addObject("peca", peca);
		
		return modelAndView;
    }
     
    @GetMapping("/pecas/delete/{id_peca}")
    public ModelAndView delete(@PathVariable("id_peca") Integer id_peca) {
        service.delete(id_peca);
        return findAll();
    }
 
    @PostMapping("/pecas/save")
    public ModelAndView save(@Validated Peca peca, Errors validacao,
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(peca);
            return new ModelAndView("/pecas/cadastropeca");
        }
        
        service.save(peca);
         
        ModelAndView mv = new ModelAndView("redirect:/pecas/add");
        redirect.addFlashAttribute("mensagem_sucesso", "A peça ["+peca.getDescPeca()+"] foi Salva com Sucesso" );
        

        return mv;
                   
    }
}
