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
import com.oficina.model.ManutencaoServico;
import com.oficina.model.Servico;
import com.oficina.service.ManutencaoService;
import com.oficina.service.ManutencaoServicoService;
import com.oficina.service.ServicoService;

@Controller
public class ManutencaoServicoController {

	@Autowired
    private ManutencaoServicoService service;
	
	@Autowired
	private ManutencaoService manutencaoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/manutencaoservicos")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/manutencaoservicos/controlemanutencaoservico");
        List<ManutencaoServico> manutencaoservicos = service.findAll();
        System.out.println("***** " + manutencaoservicos );
        
		mv.addObject("manutencaoservicos", manutencaoservicos);
		
        return mv;
    }
	
	@GetMapping("/manutencaoservicos/add")
    public ModelAndView add(ManutencaoServico manutencaoservico) {
         
        ModelAndView mv = new ModelAndView("/manutencaoservicos/cadastromanutencaoservico");
        mv.addObject("manutencaoServico", manutencaoservico);
        System.out.println("##################################"+manutencaoservico);
         
        return mv;
    }
	
	@ModelAttribute("ManutencaoTodos")
    public List<Manutencao> todasManutencoes() {
    	List<Manutencao> manutencoes = manutencaoService.findAll();
    	System.out.println("***** " + manutencoes );
		return manutencoes;
	}
	
	@ModelAttribute("ServicosTodos")
    public List<Servico> todasServicos() {
    	List<Servico> servicos = servicoService.findAll();
    	System.out.println("***** " + servicos );
		return servicos;
	}
	
	@GetMapping("/manutencaoservicos/edit/{id_ms}")
    public ModelAndView edit(@PathVariable("id_ms") Integer id) {
         
    	ManutencaoServico manutencaoServico = service.findOne(id);
		
		ModelAndView modelAndView = new ModelAndView("/manutencaoservicos/cadastromanutencaoservico");
		modelAndView.addObject("manutencaoServico", manutencaoServico);
		
		return modelAndView;
    }
     
    @GetMapping("/manutencaoservicos/delete/{id_ms}")
    public ModelAndView delete(@PathVariable("id_ms") Integer id) {
        service.delete(id);
        return findAll();
    }
    
    @PostMapping("/manutencaoservicos/save")
    public ModelAndView save(@Validated ManutencaoServico manutencaoServico, Errors validacao,  
    		Integer idManutencao,
    		Integer idServico,
    		BindingResult result,
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(manutencaoService);
            return new ModelAndView("/manutencaoservicos/cadastromanutencaoservico");
        }
        Manutencao manutencao = manutencaoService.findOne(idManutencao);
        Servico servico = servicoService.findOne(idServico);
        service.save(manutencaoServico, manutencao, servico);
        
        ModelAndView mv = new ModelAndView("redirect:/manutencaoservicos/add");
        redirect.addFlashAttribute("mensagem_sucesso", "["+manutencaoServico.getValorCobrado()+"] "+"Salvo com Sucesso" );
        
        return mv;
    }
}
