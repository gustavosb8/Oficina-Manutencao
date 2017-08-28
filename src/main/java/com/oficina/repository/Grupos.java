package com.oficina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.model.Grupo;
import com.oficina.model.Usuario;

public interface Grupos extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(Usuario usuario);
}
