package com.example.rastreabilidade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rastreabilidade.entity.OrdemProducao;
import com.example.rastreabilidade.service.OrdemProducaoService;

@RestController // requisições http p/ json ou xml
@RequestMapping("/ordens")
public class OrdemProducaoController {

  @Autowired
  private OrdemProducaoService service;

  @GetMapping
  public List<OrdemProducao> listar() {
    return service.listarTodos();
  }

  @GetMapping("/{id}")
  public Optional<OrdemProducao> buscar(@PathVariable Long id) {
    return service.buscarPorId(id);
  }

  @PostMapping
  public ResponseEntity<String> criar(@RequestBody OrdemProducao ordem) {
    service.salvar(ordem);
    return ResponseEntity.ok("Ordem de produção criada com sucesso!");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody OrdemProducao novaOrdem) {
    novaOrdem.setId(id);
    service.salvar(novaOrdem);
    return ResponseEntity.ok("Ordem de produção alterada com sucesso");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteId(@PathVariable Long id) {
    service.deletar(id);
    return ResponseEntity.ok("Excluido com sucesso!");
  }
}
