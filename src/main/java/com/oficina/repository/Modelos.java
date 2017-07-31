package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Modelo;

@Repository
public interface Modelos extends JpaRepository<Modelo, Integer>{

}
