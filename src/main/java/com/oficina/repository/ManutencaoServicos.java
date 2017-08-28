package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.ManutencaoServico;

@Repository
public interface ManutencaoServicos extends JpaRepository<ManutencaoServico, Integer> {

}