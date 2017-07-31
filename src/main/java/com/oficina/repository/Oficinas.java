package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Oficina;

@Repository
public interface Oficinas extends JpaRepository<Oficina, Integer>{

}
