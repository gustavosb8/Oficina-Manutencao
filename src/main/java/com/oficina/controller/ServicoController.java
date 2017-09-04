package com.oficina.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.model.Servico;
import com.oficina.service.ServicoService;

@Controller
public class ServicoController {

	@Autowired
    private ServicoService service;
	
    @GetMapping("/servicos")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/servicos/controleservico");
        List<Servico> servicos = service.findAll();
        /*System.out.println("***** " + servicos );*/
        
		mv.addObject("servicos", servicos);
        return mv;
    }
     

    @GetMapping("/servicos/add")
    public ModelAndView add(Servico servico) {
 
        ModelAndView mv = new ModelAndView("/servicos/cadastroservico");
        mv.addObject("servico", servico);

        return mv;
    }
     
    @GetMapping("/servicos/edit/{id_servico}")
    public ModelAndView edit(@PathVariable("id_servico") Integer id_servico) {
         
    	Servico servico = service.findOne(id_servico );
		
		ModelAndView modelAndView = new ModelAndView("/servicos/cadastroservico");
		modelAndView.addObject("servico", servico);
		
		return modelAndView;
    }
     
    @GetMapping("/servicos/delete/{id_servico}")
    public ModelAndView delete(@PathVariable("id_servico") Integer id_servico) {
        service.delete(id_servico);
        return findAll();
    }
 
    @PostMapping("/servicos/save")
    public ModelAndView save(@Validated Servico servico, Errors validacao, 
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(servico);
            return new ModelAndView("/servicos/cadastroservico");
        }
        
        service.save(servico);
         
        ModelAndView mv = new ModelAndView("redirect:/servicos/add");
        redirect.addFlashAttribute("mensagem_sucesso", "O serviço ["+servico.getDescServico()+"] foi Salvo com Sucesso" );

        return mv;
                   
    }
}
