package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Manutencao;
import com.oficina.model.Oficina;
import com.oficina.model.Veiculo;
import com.oficina.repository.Manutencoes;

@Service
public class ManutencaoService {

	@Autowired
    private Manutencoes repository;
     
    public List<Manutencao> findAll() {
        return repository.findAll();
    }
     
    public Manutencao findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Manutencao save(Manutencao manutencao, Veiculo veiculo, Oficina oficina) {
    	
    	manutencao.setOficina(oficina);
    	manutencao.setVeiculo(veiculo);
        return repository.saveAndFlush(manutencao);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
