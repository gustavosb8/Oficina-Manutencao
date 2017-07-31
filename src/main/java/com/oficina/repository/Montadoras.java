package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Montadora;

@Repository
public interface Montadoras extends JpaRepository<Montadora, Integer>{

}
