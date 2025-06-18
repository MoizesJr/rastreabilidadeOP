package com.example.rastreabilidade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rastreabilidade.entity.Usuario;
import com.example.rastreabilidade.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = " * ")
public class UsuarioController {

  @Autowired
  private UsuarioService service;

  @GetMapping
  public List<Usuario> listar() {
    return service.listarTodos();
  }

  @GetMapping("/{id}")
  public Optional<Usuario> buscar(@PathVariable Long id) {
    return service.buscarPorId(id);
  }

  @PostMapping
  public Usuario criar(@RequestBody Usuario usuario) {
    return service.salvar(usuario);
  }

  @PutMapping("/{id}")
  public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
    usuario.setId(id);
    return service.salvar(usuario);
  }

  @DeleteMapping
  public void deletar(@PathVariable Long id) {
    service.deletar(id);
  }
}
