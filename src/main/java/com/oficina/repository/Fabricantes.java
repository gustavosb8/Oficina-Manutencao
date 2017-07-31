package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Fabricante;

@Repository
public interface Fabricantes extends JpaRepository<Fabricante, Integer>{

}
