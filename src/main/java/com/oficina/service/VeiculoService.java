package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Loja;
import com.oficina.model.Modelo;
import com.oficina.model.Veiculo;
import com.oficina.repository.Manutencoes;
import com.oficina.repository.Veiculos;

@Service
public class VeiculoService {

	@Autowired
    private Veiculos repository;
	
	@Autowired
	private Manutencoes manutencoes;
     
    public List<Veiculo> findAll() {
        return repository.findAll();
    }
     
    public Veiculo findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public Veiculo save(Veiculo veiculo, Modelo modelo, Loja loja) {

    	veiculo.setManutencoes(manutencoes.findAll());
    	veiculo.setModelo(modelo);
    	veiculo.setLoja(loja);
        return repository.saveAndFlush(veiculo);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
