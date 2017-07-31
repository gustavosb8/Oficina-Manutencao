package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.TipoVeiculo;
import com.oficina.repository.Modelos;
import com.oficina.repository.TipoVeiculos;

@Service
public class TipoVeiculoService {
	
	@Autowired
    private TipoVeiculos repository;
	
	@Autowired
    private Modelos modelos;
	
	public List<TipoVeiculo> findAll() {
        return repository.findAll();
    }
     
    public TipoVeiculo findOne(Integer id) {
        return repository.findOne(id);
    }
    
    
    public TipoVeiculo save(TipoVeiculo tipoVeiculo) {
        
    	tipoVeiculo.setModelos(modelos.findAll());
    	return repository.saveAndFlush(tipoVeiculo);
    }
    
     
    public void delete(Integer id) {
        repository.delete(id);
    }

}
