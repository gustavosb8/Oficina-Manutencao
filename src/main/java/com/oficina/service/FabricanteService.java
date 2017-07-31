package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Fabricante;

import com.oficina.repository.Fabricantes;
import com.oficina.repository.Pecas;
import com.oficina.repository.Produtos;

@Service
public class FabricanteService {

	@Autowired
    private Fabricantes repository;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Pecas pecas;
     
    public List<Fabricante> findAll() {
        return repository.findAll();
    }
     
    public Fabricante findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Fabricante save(Fabricante fabricante) {

    	fabricante.setProdutos(produtos.findAll());
    	fabricante.setPecas(pecas.findAll());
        return repository.saveAndFlush(fabricante);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
