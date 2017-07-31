package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Veiculo;

@Repository
public interface Veiculos extends JpaRepository<Veiculo, Integer>{

}
