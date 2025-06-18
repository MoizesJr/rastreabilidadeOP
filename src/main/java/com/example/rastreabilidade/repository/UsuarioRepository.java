package com.example.rastreabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rastreabilidade.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  boolean existsByEmail(String email);
}
