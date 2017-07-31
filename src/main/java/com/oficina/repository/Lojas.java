package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.Loja;

@Repository
public interface Lojas extends JpaRepository<Loja, Integer>{

}
