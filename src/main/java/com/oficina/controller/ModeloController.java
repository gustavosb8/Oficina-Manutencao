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

import com.oficina.model.Modelo;
import com.oficina.model.Montadora;
import com.oficina.model.TipoVeiculo;
import com.oficina.service.MontadoraService;
import com.oficina.service.TipoVeiculoService;
import com.oficina.service.ModeloService;

@Controller
public class ModeloController {

	@Autowired
    private ModeloService service;
	
	@Autowired
	private MontadoraService montadoraService;
	
	@Autowired
	private TipoVeiculoService tpService;
	
	
	@GetMapping("/modelos")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("modelos/controlemodelo");
        List<Modelo> modelos = service.findAll();
        System.out.println("***** " + modelos );
        
		mv.addObject("modelos", modelos);
		
        return mv;
    }
	
	@GetMapping("/modelos/add")
    public ModelAndView add(Modelo modelo) {
         
        ModelAndView mv = new ModelAndView("modelos/cadastromodelo");
        mv.addObject("modelo", modelo);
         
        return mv;
    }
	
	@ModelAttribute("MontadorasTodos")
    public List<Montadora> todosModelos() {
    	List<Montadora> montadoras = montadoraService.findAll();
    	System.out.println("***** " + montadoras );
		return montadoras;
	}
	
	@ModelAttribute("TipoVeiculoTodos")
    public List<TipoVeiculo> todosTipos() {
    	List<TipoVeiculo> tpVeiculos = tpService.findAll();
    	System.out.println("***** " + tpVeiculos );
		return tpVeiculos;
	}
	
	@GetMapping("/modelos/edit/{id_modelo}")
    public ModelAndView edit(@PathVariable("id_modelo") Integer id_modelo) {
         
		Modelo modelo = service.findOne(id_modelo);
		
		ModelAndView modelAndView = new ModelAndView("modelos/cadastromodelo");
		modelAndView.addObject("modelo", modelo);
		
		return modelAndView;
    }
     
    @GetMapping("/modelos/delete/{id_modelo}")
    public ModelAndView delete(@PathVariable("id_modelo") Integer id_modelo) {
        service.delete(id_modelo);
        return findAll();
    }
    
    @PostMapping("/modelos/save")
    public ModelAndView save(@Validated Modelo modelo, Errors validacao,
    		Integer idMontadora,
    		Integer idTipoVeiculo,
    		BindingResult result,
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(Modelo);
            return new ModelAndView("modelos/cadastromodelo");
        }
      
        
        Montadora montadora = montadoraService.findOne(idMontadora);
        TipoVeiculo tpVeiculo = tpService.findOne(idTipoVeiculo);
        service.save(modelo, montadora, tpVeiculo);
        
        ModelAndView mv = new ModelAndView("redirect:/modelos/add");
        redirect.addFlashAttribute("mensagem_sucesso", "O Modelo ["+modelo.getDescModelo()+"] foi Salvo com Sucesso" );

        return mv;
    }
}
