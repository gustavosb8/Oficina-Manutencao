package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.model.Fabricante;
import com.oficina.model.Manutencao;
import com.oficina.model.ManutencaoProduto;
import com.oficina.model.Produto;
import com.oficina.repository.Fabricantes;
import com.oficina.repository.ManutencaoProdutos;
import com.oficina.repository.Manutencoes;
import com.oficina.repository.Produtos;

@Service
public class ManutencaoProdutoService {

	@Autowired
	private ManutencaoProdutos repository;
	
	@Autowired
	private Manutencoes manutencoes;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Fabricantes fabricantes;
	
	 public List<ManutencaoProduto> findAll() {
		 return repository.findAll();
	 }
	     
	 public ManutencaoProduto findOne(Integer id) {
		 return repository.findOne(id);
	 }
	 
	 public ManutencaoProduto save(ManutencaoProduto manutencaoProduto, Manutencao manutencao, Produto produto, Fabricante fabricante){
		 manutencaoProduto.setManutencao(manutencoes.findOne(manutencao.getIdManutencao()));
		 manutencaoProduto.setProduto(produtos.findOne(produto.getIdProduto()));
		 manutencaoProduto.setFabricante(fabricantes.findOne(fabricante.getIdFabricante()));
		 
		 System.out.println("##################################"+manutencaoProduto);
		 
		 return repository.saveAndFlush(manutencaoProduto);
	 }
	 
	 public void delete(Integer id) {
		 repository.delete(id);
	 }
}
