package com.oficina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oficina.model.Usuario;


@Repository
public interface Usuarios extends JpaRepository<Usuario, Integer>{

   Usuario findByNome(String nome);
   Usuario findByEmail(String email);

}