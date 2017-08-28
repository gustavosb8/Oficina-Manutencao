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

import com.oficina.service.ManutencaoProdutoService;
import com.oficina.service.ManutencaoService;
import com.oficina.service.ProdutoService;
import com.oficina.model.Fabricante;
import com.oficina.model.Manutencao;
import com.oficina.model.ManutencaoProduto;
import com.oficina.model.Produto;
import com.oficina.service.FabricanteService;


@Controller
public class ManutencaoProdutoController {
	
	@Autowired
    private ManutencaoProdutoService service;
	
	@Autowired
    private ManutencaoService manutencaoService;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private FabricanteService fabricanteService;
    
    @GetMapping("/manutencaoprodutos")
    public ModelAndView findAll() {
         
	 /********************ALTERAR*******************************/
        ModelAndView mv = new ModelAndView("/manutencaoprodutos/controlemanutencaoproduto");
        List<ManutencaoProduto> manutencaoProdutos = service.findAll();
        System.out.println("***** " + manutencaoProdutos );
        
		mv.addObject("manutencaoprodutos", manutencaoProdutos);
		
        return mv;
    }
	
	@GetMapping("/manutencaoprodutos/add")
    public ModelAndView add(ManutencaoProduto manutencaoproduto) {
         
        ModelAndView mv = new ModelAndView("/manutencaoprodutos/cadastromanutencaoproduto");
        mv.addObject("manutencaoProduto", manutencaoproduto);
        System.out.println("##################################"+manutencaoproduto);
         
        return mv;
    }
	
	@ModelAttribute("ManutencaoTodos")
    public List<Manutencao> todasManutencoes() {
    	List<Manutencao> manutencoes = manutencaoService.findAll();
    	System.out.println("***** " + manutencoes );
		return manutencoes;
	}
	
	@ModelAttribute("FabricanteTodos")
    public List<Fabricante> todasFabricantes() {
    	List<Fabricante> fabricantes = fabricanteService.findAll();
    	System.out.println("***** " + fabricantes );
		return fabricantes;
	}
	
	@ModelAttribute("ProdutoTodos")
    public List<Produto> todasProdutos() {
    	List<Produto> produtos = produtoService.findAll();
    	System.out.println("***** " + produtos );
		return produtos;
	}
	
	@GetMapping("/manutencaoprodutos/edit/{id_mp}")
    public ModelAndView edit(@PathVariable("id_mp") Integer id) {
         
    	ManutencaoProduto manutencaoProduto = service.findOne(id);
		
		ModelAndView modelAndView = new ModelAndView("/manutencaoprodutos/cadastromanutencaoproduto");
		modelAndView.addObject("manutencaoProduto", manutencaoProduto);
		
		return modelAndView;
    }
     
    @GetMapping("/manutencaoprodutos/delete/{id_mp}")
    public ModelAndView delete(@PathVariable("id_mp") Integer id) {
        service.delete(id);
        return findAll();
    }
    
    @PostMapping("/manutencaoprodutos/save")
    public String save(@Validated ManutencaoProduto manutencaoProduto, 
    		Integer idManutencao,
    		Long idProduto,
    		Integer idFabricante,
    		BindingResult result,
    		Errors validacao,  
    		RedirectAttributes redirect,
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(manutencaoService);
            return "manutencaoprodutos/cadastromanutencaoproduto";
        }
        
        Manutencao manutencao = manutencaoService.findOne(idManutencao);
        Produto produto = produtoService.findOne(idProduto);
        Fabricante fabricante = fabricanteService.findOne(idFabricante);
        
        service.save(manutencaoProduto, manutencao, produto, fabricante);
        
        redirect.addFlashAttribute("mensagem_sucesso", "Salvo com Sucesso" );
        String rota = manutencaoProduto.ehNovo() ? "redirect:/manutencaoprodutos/add" : "redirect:/manutencaoprodutos";

        return rota;
    }
    
    
    
}
