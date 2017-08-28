package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Manutencao;
import com.oficina.model.ManutencaoServico;
import com.oficina.model.Servico;
import com.oficina.repository.ManutencaoServicos;
import com.oficina.repository.Manutencoes;
import com.oficina.repository.Servicos;

@Service
public class ManutencaoServicoService {

	@Autowired
	private ManutencaoServicos repository;
	
	@Autowired
	private Manutencoes manutencoes;
	
	@Autowired
	private Servicos servicos;
	
	 public List<ManutencaoServico> findAll() {
        return repository.findAll();
    }
     
    public ManutencaoServico findOne(Integer id) {
        return repository.findOne(id);
    }
     
    public ManutencaoServico save(ManutencaoServico manutencaoServico, Manutencao manutencao, Servico servico) {

    	manutencaoServico.setManutencao(manutencoes.findOne(manutencao.getIdManutencao()));
    	manutencaoServico.setServico(servicos.findOne(servico.getIdServico()));
    	System.out.println("##################################"+manutencaoServico);
    	
        return repository.saveAndFlush(manutencaoServico);
    }
     
    public void delete(Integer id) {
        repository.delete(id);
    }
}
