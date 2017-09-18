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

import com.oficina.model.TipoVeiculo;
import com.oficina.service.TipoVeiculoService;

@Controller
public class TipoVeiculoController {

	@Autowired
    private TipoVeiculoService service;
	
    @GetMapping("/tipoveiculos")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("tipoveiculos/controletipoveiculo");
        List<TipoVeiculo> tpveiculos = service.findAll();
        /*System.out.println("***** " + tpveiculos );*/
		mv.addObject("tpveiculos", tpveiculos);  
        return mv;
    }
     

    @GetMapping("/tipoveiculos/add")
    public ModelAndView add(TipoVeiculo tpveiculos) {
 
        ModelAndView mv = new ModelAndView("tipoveiculos/cadastrotipoveiculo");
        mv.addObject("tpveiculos", tpveiculos);

        return mv;
    }
     
    @GetMapping("/tipoveiculos/edit/{id_tipo_veiculo}")
    public ModelAndView edit(@PathVariable("id_tipo_veiculo") Integer id_tpveiculos) {
         
    	TipoVeiculo tipoVeiculo = service.findOne(id_tpveiculos);
		
		ModelAndView modelAndView = new ModelAndView("tipoveiculos/cadastrotipoveiculo");
		modelAndView.addObject("tipoVeiculo", tipoVeiculo);
		
		return modelAndView;
    }
     
    @GetMapping("/tipoveiculos/delete/{id_tipo_veiculo}")
    public ModelAndView delete(@PathVariable("id_tipo_veiculo") Integer id_tpveiculos) {
        service.delete(id_tpveiculos);
        return findAll();
    }
 
    @PostMapping("/tipoveiculos/save")
    public ModelAndView save(@Validated TipoVeiculo tpVeiculo, Errors validacao, 
    		RedirectAttributes redirect,
    		BindingResult result, 
    		HttpServletRequest request ) {
        
        if(validacao.hasErrors()) {
            //return add(tpVeiculo);
            return new ModelAndView("tipoveiculos/cadastrotipoveiculo");
        }
         
        service.save(tpVeiculo);
         
        ModelAndView mv = new ModelAndView("redirect:/tipoveiculos/add");
        redirect.addFlashAttribute( "mensagem_sucesso", "Tipo Veiculo ["+tpVeiculo.getDesc_tipoVeiculo()+"] Salvo com Sucesso" );

        return mv;
                   
    }
}
