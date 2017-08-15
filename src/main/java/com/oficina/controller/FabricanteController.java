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
import com.oficina.model.Produto;
import com.oficina.service.FabricanteService;
import com.oficina.service.PecaService;
import com.oficina.service.ProdutoService;

@Controller
public class FabricanteController {

	@Autowired
    private FabricanteService service;
	
	@Autowired
    private ProdutoService produtoService;
	
	@Autowired
    private PecaService pecaService;
	
    @GetMapping("/fabricantes")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/fabricantes/controlefabricante");
        List<Fabricante> fabricantes = service.findAll();
        /*System.out.println("***** " + fabricantes );*/
        
		mv.addObject("fabricantes", fabricantes);
         
        
        
        return mv;
    }
     

    @GetMapping("/fabricantes/add")
    public ModelAndView add(Fabricante fabricante) {
 
        ModelAndView mv = new ModelAndView("/fabricantes/cadastrofabricante");
        mv.addObject("fabricante", fabricante);

        return mv;
    }
    
    @ModelAttribute("ProdutosTodos")
    public List<Produto> todasProdutos() {
    	List<Produto> produtos = produtoService.findAll();
    	System.out.println("***** " + produtos );
		return produtos;
	}
    
    @ModelAttribute("PecasTodos")
    public List<Peca> todasPecas() {
    	List<Peca> pecas = pecaService.findAll();
    	System.out.println("***** " + pecas );
		return pecas;
	}
 
     
    @GetMapping("/fabricantes/edit/{id_fabricante}")
    public ModelAndView edit(@PathVariable("id_fabricante") Integer id_fabricante) {
         
    	Fabricante fabricante = service.findOne(id_fabricante );
		
		ModelAndView modelAndView = new ModelAndView("/fabricantes/cadastrofabricante");
		modelAndView.addObject("fabricante", fabricante);
		
		return modelAndView;
    }
     
    @GetMapping("/fabricantes/delete/{id_fabricante}")
    public ModelAndView delete(@PathVariable("id_fabricante") Integer id_fabricante) {
        service.delete(id_fabricante);
        return findAll();
    }
 
    @PostMapping("/fabricantes/save")
    public String save(@Validated Fabricante fabricante, 
    		Errors validacao,  
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(fabricante);
            return "fabricantes/cadastrofabricante";
        }
        
        service.save(fabricante);
         
        redirect.addFlashAttribute("mensagem_sucesso", "O Fabricante foi Salvo com Sucesso" );
        String rota = fabricante.ehNovo() ? "redirect:/fabricantes/add" : "redirect:/fabricantes";

        return rota;
                   
    }
}
