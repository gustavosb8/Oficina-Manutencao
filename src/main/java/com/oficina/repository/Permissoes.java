package com.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.model.Grupo;
import com.oficina.model.Permissao;

public interface Permissoes extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(Grupo grupo);
}
