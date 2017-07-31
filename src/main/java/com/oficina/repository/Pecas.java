package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Peca;

@Repository
public interface Pecas extends JpaRepository<Peca, Integer>{

}
