package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

	Usuario findByLogin(String login);
}
