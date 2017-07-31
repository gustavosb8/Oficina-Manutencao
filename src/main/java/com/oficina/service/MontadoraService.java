package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Montadora;
import com.oficina.repository.Lojas;
import com.oficina.repository.Modelos;
import com.oficina.repository.Montadoras;
import com.oficina.repository.Oficinas;

@Service
public class MontadoraService {

	@Autowired
	private Montadoras repository;
	
	@Autowired
	private Lojas lojas;
	
	@Autowired
	private Oficinas oficinas;
	
	@Autowired
	private Modelos modelos;
	
	public List<Montadora> findAll() {
        return repository.findAll();
    }
     
    public Montadora findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Montadora save(Montadora montadora) {
    	
    	montadora.setLojas(lojas.findAll());
    	montadora.setOficinas(oficinas.findAll());
    	montadora.setModelos(modelos.findAll());
        return repository.saveAndFlush(montadora);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
