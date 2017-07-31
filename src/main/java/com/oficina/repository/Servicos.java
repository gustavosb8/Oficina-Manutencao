package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oficina.model.Servico;

@Repository
public interface Servicos extends JpaRepository<Servico, Integer>{

}
