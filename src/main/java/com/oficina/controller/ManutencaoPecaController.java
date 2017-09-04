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
import com.oficina.model.Manutencao;
import com.oficina.model.ManutencaoPeca;
import com.oficina.model.Peca;
import com.oficina.service.FabricanteService;
import com.oficina.service.ManutencaoPecaService;
import com.oficina.service.ManutencaoService;
import com.oficina.service.PecaService;

@Controller
public class ManutencaoPecaController {
	
	@Autowired
    private ManutencaoPecaService service;
	
	@Autowired
    private ManutencaoService manutencaoService;
	
	@Autowired
    private PecaService pecaService;
	
	@Autowired
    private FabricanteService fabricanteService;
	
	@GetMapping("/manutencaopecas")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/manutencaopecas/controlemanutencaopeca");
        List<ManutencaoPeca> manutencaopecas = service.findAll();
        System.out.println("***** " + manutencaopecas );
        
		mv.addObject("manutencaopecas", manutencaopecas);
		
        return mv;
    }
	
	@GetMapping("/manutencaopecas/add")
    public ModelAndView add(ManutencaoPeca manutencaoPeca) {
         
        ModelAndView mv = new ModelAndView("/manutencaopecas/cadastromanutencaopeca");
        mv.addObject("manutencaoPeca", manutencaoPeca);
        System.out.println("##################################" + manutencaoPeca);
         
        return mv;
    }
	
	@ModelAttribute("ManutencaoTodos")
    public List<Manutencao> todasManutencoes() {
    	List<Manutencao> manutencoes = manutencaoService.findAll();
    	System.out.println("***** " + manutencoes );
		return manutencoes;
	}
	
	@ModelAttribute("PecaTodos")
    public List<Peca> todasPecas() {
    	List<Peca> pecas = pecaService.findAll();
    	System.out.println("***** " + pecas );
		return pecas;
	}
	
	@ModelAttribute("FabricanteTodos")
    public List<Fabricante> todasFabricantes() {
    	List<Fabricante> pecas = fabricanteService.findAll();
    	System.out.println("***** " + pecas );
		return pecas;
	}
	
	@GetMapping("/manutencaopeca/edit/{id_mpe}")
    public ModelAndView edit(@PathVariable("id_mpe") Integer id) {
         
    	ManutencaoPeca manutencaoPeca = service.findOne(id);
		
		ModelAndView modelAndView = new ModelAndView("/manutencaopecas/cadastromanutencaopeca");
		modelAndView.addObject("manutencaoPeca", manutencaoPeca);
		
		return modelAndView;
    }
     
    @GetMapping("/manutencaopecas/delete/{id_mpe}")
    public ModelAndView delete(@PathVariable("id_mpe") Integer id) {
        service.delete(id);
        return findAll();
    }
    
    @PostMapping("/manutencaopecas/save")
    public ModelAndView save(@Validated ManutencaoPeca manutencaoPeca, Errors validacao, 
    		Integer idManutencao,
    		Integer idPeca,
    		Integer idFabricante,
    		BindingResult result,
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(manutencaoService);
            return new ModelAndView("/manutencaoservicos/cadastromanutencaoservico");
        }
        Manutencao manutencao = manutencaoService.findOne(idManutencao);
        Peca peca = pecaService.findOne(idPeca);
        Fabricante fabricante = fabricanteService.findOne(idFabricante);
        
        service.save(manutencaoPeca, manutencao, peca, fabricante);
        
        ModelAndView mv = new ModelAndView("redirect:/manutencaopecas/add");
        redirect.addFlashAttribute("mensagem_sucesso", "["+manutencaoPeca.getValorCobrado()+"] Salvo com Sucesso" );

        return mv;
    }
	
	
}
