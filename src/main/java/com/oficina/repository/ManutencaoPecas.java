package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oficina.model.ManutencaoPeca;

@Repository
public interface ManutencaoPecas extends JpaRepository<ManutencaoPeca, Integer> {

}
