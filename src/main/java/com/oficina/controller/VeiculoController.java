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
import com.oficina.model.Modelo;
import com.oficina.model.Veiculo;
import com.oficina.service.LojaService;
import com.oficina.service.ModeloService;
import com.oficina.service.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
    private VeiculoService service;
	
	@Autowired
    private ModeloService modeloService;
	
	@Autowired
    private LojaService lojaService;
	
    @GetMapping("/veiculos")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/veiculos/controleveiculo");
        List<Veiculo> veiculos = service.findAll();
        /*System.out.println("***** " + veiculos );*/
        
		mv.addObject("veiculos", veiculos);
         
        
        
        return mv;
    }
     

    @GetMapping("/veiculos/add")
    public ModelAndView add(Veiculo veiculo) {
 
        ModelAndView mv = new ModelAndView("/veiculos/cadastroveiculo");
        mv.addObject("veiculos", veiculo);

        return mv;
    }
    
    @ModelAttribute("ModelosTodos")
    public List<Modelo> todasModelos() {
    	List<Modelo> modelos = modeloService.findAll();
    	System.out.println("***** " + modelos );
		return modelos;
	}
    
    @ModelAttribute("LojasTodos")
    public List<Loja> todasLojas() {
    	List<Loja> lojas = lojaService.findAll();
    	System.out.println("***** " + lojas );
		return lojas;
	}
     
    @GetMapping("/veiculos/edit/{id_renavam}")
    public ModelAndView edit(@PathVariable("id_renavam") Integer id_renavam) {
         
    	Veiculo veiculo = service.findOne(id_renavam );
		
		ModelAndView modelAndView = new ModelAndView("/veiculos/cadastroveiculo");
		modelAndView.addObject("veiculo", veiculo);
		
		return modelAndView;
    }
     
    @GetMapping("/veiculos/delete/{id_renavam}")
    public ModelAndView delete(@PathVariable("id_renavam") Integer id_renavam) {
        service.delete(id_renavam);
        return findAll();
    }
 
    @PostMapping("/veiculos/save")
    public ModelAndView save(@Validated Veiculo veiculo,
    		Integer idModelo,
    		Integer idLoja,
    		Errors validacao,  
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
    	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%% "+validacao.hasErrors());;
    	
        if(validacao.hasErrors()) {
            
        	return new ModelAndView("/veiculos/cadastroveiculo");
        }
        
        Modelo modelo = modeloService.findOne(idModelo);
        Loja loja = lojaService.findOne(idLoja);
        service.save(veiculo, modelo, loja);
        
        
        //ModelAndView mv = new ModelAndView(veiculo.ehNovo() ? "redirect:/veiculos/add" : "redirect:/veiculos");
        
        ModelAndView mv = new ModelAndView("redirect:/veiculos/add");
        redirect.addFlashAttribute("mensagem_sucesso", "O Fabricante ["+veiculo.getDescricaoCor()+" "+veiculo.getObservacao()+"] foi Salvo com Sucesso" );

        return mv;
                   
    }
}
