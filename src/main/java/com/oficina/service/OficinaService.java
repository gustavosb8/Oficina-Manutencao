package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Montadora;
import com.oficina.model.Oficina;
import com.oficina.repository.Manutencoes;
import com.oficina.repository.Oficinas;

@Service
public class OficinaService {

	@Autowired
    private Oficinas repository;
	
	@Autowired
    private Manutencoes manutencoes;
	
	public List<Oficina> findAll() {
        return repository.findAll();
    }
     
    public Oficina findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Oficina save(Oficina oficina, Montadora montadora) {
    	oficina.setManutencoes(manutencoes.findAll());
    	oficina.setMontadoraOficina(montadora);
        return repository.saveAndFlush(oficina);
    }
    
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
