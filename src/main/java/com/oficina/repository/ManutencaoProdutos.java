package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.ManutencaoProduto;

@Repository
public interface ManutencaoProdutos extends JpaRepository<ManutencaoProduto, Integer>{

}
