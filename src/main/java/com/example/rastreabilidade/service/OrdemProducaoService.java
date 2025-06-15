package com.example.rastreabilidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rastreabilidade.entity.OrdemProducao;
import com.example.rastreabilidade.repository.OrdemProducaoRepository;

@Service
public class OrdemProducaoService {

  @Autowired
  private OrdemProducaoRepository repository;

  public List<OrdemProducao> listarTodos() {
    return repository.findAll();
  }

  public Optional<OrdemProducao> buscarPorId(Long id) {
    return repository.findById(id);
  }

  public OrdemProducao salvar(OrdemProducao ordem) {
    return repository.save(ordem);
  }

  public void deletar(Long id) {
    repository.deleteById(id);
  }
}
