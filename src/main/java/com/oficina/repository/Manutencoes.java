package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Manutencao;

@Repository
public interface Manutencoes extends JpaRepository<Manutencao, Integer>{


}
