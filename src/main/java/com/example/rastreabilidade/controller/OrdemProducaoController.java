package com.example.rastreabilidade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rastreabilidade.entity.OrdemProducao;
import com.example.rastreabilidade.repository.OrdemProducaoRepository;

@RestController // requisições http p/ json ou xml
@RequestMapping("/api/ordens")
public class OrdemProducaoController {

  @Autowired
  private OrdemProducaoRepository repository;

  @GetMapping
  public List<OrdemProducao> listar() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<OrdemProducao> searchId(@PathVariable Long id) {
    return repository.findById(id);
  }

  @PostMapping
  public ResponseEntity<String> criar(@RequestBody @PathVariable OrdemProducao ordem) {
    repository.save(ordem);
    return ResponseEntity.ok("Ordem de produção criada com sucesso!");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteId(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.ok("Excluido com sucesso!");
  }
}
