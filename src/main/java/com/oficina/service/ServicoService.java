package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oficina.model.Servico;
import com.oficina.repository.Servicos;

@Service
public class ServicoService {

	@Autowired
    private Servicos repository;
	
	//@Autowired
	//?
     
    public List<Servico> findAll() {
        return repository.findAll();
    }
     
    public Servico findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Servico save(Servico servico) {

    	//servico.setManutencoes(manutencoes.findAll());
        return repository.saveAndFlush(servico);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}



