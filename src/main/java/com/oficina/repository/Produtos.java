package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oficina.model.Produto;

@Repository
public interface Produtos extends JpaRepository<Produto, Long>{

}
