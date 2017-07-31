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
import com.oficina.model.Manutencao;
import com.oficina.model.Oficina;
import com.oficina.model.Veiculo;
import com.oficina.service.ManutencaoService;
import com.oficina.service.OficinaService;
import com.oficina.service.VeiculoService;

@Controller
public class ManutencaoController {

	@Autowired
    private ManutencaoService service;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private OficinaService oficinaService;
	
	@GetMapping("/manutencoes")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/manutencao/controlemanutencao");
        List<Manutencao> manutencoes = service.findAll();
        System.out.println("***** " + manutencoes );
        
		mv.addObject("manutencoes", manutencoes);
		
        return mv;
    }
	
	@GetMapping("/manutencoes/add")
    public ModelAndView add(Manutencao manutencao) {
         
        ModelAndView mv = new ModelAndView("/manutencao/cadastromanutencao");
        mv.addObject("manutencoes", manutencao);
         
        return mv;
    }
	
	@ModelAttribute("VeiculosTodos")
    public List<Veiculo> todasManutencoes() {
    	List<Veiculo> veiculos = veiculoService.findAll();
    	System.out.println("***** " + veiculos );
		return veiculos;
	}
	
	@ModelAttribute("OficinaTodos")
    public List<Oficina> todasOficinas() {
    	List<Oficina> oficinas = oficinaService.findAll();
    	System.out.println("***** " + oficinas );
		return oficinas;
	}
	
	@GetMapping("/manutencoes/edit/{id_manutencao}")
    public ModelAndView edit(@PathVariable("id_manutencao") Integer id_manutencao) {
         
    	Manutencao manutencao = service.findOne(id_manutencao);
		
		ModelAndView modelAndView = new ModelAndView("/manutencao/cadastromanutencao");
		modelAndView.addObject("manutencao", manutencao);
		
		return modelAndView;
    }
     
    @GetMapping("/manutencoes/delete/{id_manutencao}")
    public ModelAndView delete(@PathVariable("id_manutencao") Integer id_manutencao) {
        service.delete(id_manutencao);
        return findAll();
    }
    
    @PostMapping("/manutencoes/save")
    public String save(@Validated Manutencao manutencao, 
    		Integer idVeiculo,
    		Integer idOficina,
    		BindingResult result,
    		Errors validacao,  
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(manutencao);
            return "manutencao/cadastromanutencao";
        }
        Veiculo veiculo = veiculoService.findOne(idVeiculo);
        Oficina oficina = oficinaService.findOne(idOficina);
        service.save(manutencao, veiculo, oficina);
        
        redirect.addFlashAttribute("mensagem_sucesso", "O livro foi Salvo com Sucesso" );
        String rota = manutencao.ehNovo() ? "redirect:/manutencoes/add" : "redirect:/manutencoes";

        return rota;
    }
}
