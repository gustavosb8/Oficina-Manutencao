package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Modelo;
import com.oficina.model.Montadora;
import com.oficina.model.TipoVeiculo;
import com.oficina.repository.Modelos;
import com.oficina.repository.Veiculos;

@Service
public class ModeloService {

	@Autowired
    private Modelos repository;
	
	@Autowired
	private Veiculos veiculos;
	
	public List<Modelo> findAll() {
        return repository.findAll();
    }
     
    public Modelo findOne(Integer id) {
        return repository.findOne(id);
    }
     
    
    public Modelo save(Modelo modelo, Montadora montadora, TipoVeiculo tpVeiculo) {
    	
    	modelo.setVeiculos(veiculos.findAll());
    	modelo.setMontadoraModelo(montadora);
    	modelo.setTipoVeiculo(tpVeiculo);
        return repository.saveAndFlush(modelo);
    }
    
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
