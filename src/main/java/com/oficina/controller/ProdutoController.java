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
import com.oficina.model.Produto;
import com.oficina.service.FabricanteService;
import com.oficina.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
    private ProdutoService service;
	
	@Autowired
    private FabricanteService fabricanteService;

	
    @GetMapping("/produtos")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/produtos/controleproduto");
        List<Produto> produtos = service.findAll();
        /*System.out.println("***** " + produtos );*/
        
		mv.addObject("produtos", produtos);

        return mv;
    }
     

    @GetMapping("/produtos/add")
    public ModelAndView add(Produto produto) {
 
        ModelAndView mv = new ModelAndView("/produtos/cadastroproduto");
        mv.addObject("produto", produto);

        return mv;
    }
    
    @ModelAttribute("FabricanteTodos")
    public List<Fabricante> todasFabricantes() {
    	List<Fabricante> fabricantes = fabricanteService.findAll();
    	System.out.println("***** " + fabricantes );
		return fabricantes;
	}
     
    @GetMapping("/produtos/edit/{id_produto}")
    public ModelAndView edit(@PathVariable("id_produto") Integer id_produto) {
         
    	Produto produto = service.findOne(id_produto );
		
		ModelAndView modelAndView = new ModelAndView("/produtos/cadastroproduto");
		modelAndView.addObject("produto", produto);
		
		return modelAndView;
    }
     
    @GetMapping("/produtos/delete/{id_produto}")
    public ModelAndView delete(@PathVariable("id_produto") Integer id_produto) {
        service.delete(id_produto);
        return findAll();
    }
 
    @PostMapping("/produtos/save")
    public String save(@Validated Produto produto, 
    		Integer idFabricante, /*Alterar pra um vetor de id's*/
    		Errors validacao,  
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(produto);
            return "produtos/cadastroproduto";
        }
         
        Fabricante fabricante = fabricanteService.findOne(idFabricante);
        produto.getFabricante().add(fabricante);
        service.save(produto);
         
        redirect.addFlashAttribute("mensagem_sucesso", "O Produto foi Salvo com Sucesso" );
        String rota = produto.ehNovo() ? "redirect:/produtos/add" : "redirect:/produtos";

        return rota;
                   
    }
}
