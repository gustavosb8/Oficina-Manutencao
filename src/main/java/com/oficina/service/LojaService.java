package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Loja;
import com.oficina.model.Montadora;
import com.oficina.repository.Lojas;
import com.oficina.repository.Veiculos;

@Service
public class LojaService {

	@Autowired
    private Lojas repository;
	
	@Autowired
    private Veiculos veiculos;
	
    public List<Loja> findAll() {
        return repository.findAll();
    }
     
    public Loja findOne(Integer id) {
        return repository.findOne(id);
    }
    
    public Loja save(Loja loja, Montadora montadora) {
    	
    	loja.setVeiculos(veiculos.findAll());
    	loja.setMontadoraLoja(montadora);
        return repository.saveAndFlush(loja);
    }
    
    public void delete(Integer id) {
        repository.delete(id);
    }
}
