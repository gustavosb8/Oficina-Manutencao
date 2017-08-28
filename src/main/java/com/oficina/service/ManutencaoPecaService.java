package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Fabricante;
import com.oficina.model.Manutencao;
import com.oficina.model.ManutencaoPeca;
import com.oficina.model.Peca;
import com.oficina.repository.Fabricantes;
import com.oficina.repository.ManutencaoPecas;
import com.oficina.repository.Manutencoes;
import com.oficina.repository.Pecas;

@Service
public class ManutencaoPecaService {

	@Autowired
	private ManutencaoPecas repository;
	
	@Autowired
	private Manutencoes manutencoes;
	
	@Autowired
	private Pecas pecas;
	
	@Autowired
	private Fabricantes fabricantes;
	
	 public List<ManutencaoPeca> findAll() {
		 return repository.findAll();
	 }
	     
	 public ManutencaoPeca findOne(Integer id) {
		 return repository.findOne(id);
	 }
	 
	 public ManutencaoPeca save(ManutencaoPeca manutencaoPeca, Manutencao manutencao, Peca peca, Fabricante fabricante){
		 manutencaoPeca.setManutencao(manutencoes.findOne(manutencao.getIdManutencao()));
		 manutencaoPeca.setPeca(pecas.findOne(peca.getIdPeca()));
		 manutencaoPeca.setFabricante(fabricantes.findOne(fabricante.getIdFabricante()));
		 
		 System.out.println("##################################"+manutencaoPeca);
		 
		 return repository.saveAndFlush(manutencaoPeca);
	 }
	 
	 public void delete(Integer id) {
		 repository.delete(id);
	 }
}
