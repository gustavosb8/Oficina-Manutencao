package com.oficina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.oficina.model.Produto;
import com.oficina.repository.Produtos;

@Service
public class ProdutoService {

	@Autowired
    private Produtos repository;
     
    public List<Produto> findAll() {
        return repository.findAll();
    }
     
    public Produto findOne(Long id) {
        return repository.findOne(id);
    }
     
    public Produto save(Produto produto /*LIST<Fabricante>????*/) {

        return repository.saveAndFlush(produto);
    }
     
    public void delete(Long id) {
        repository.delete(id);
    }
}
