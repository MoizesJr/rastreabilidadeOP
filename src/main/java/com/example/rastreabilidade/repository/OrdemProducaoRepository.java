package com.example.rastreabilidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rastreabilidade.entity.OrdemProducao;

public interface OrdemProducaoRepository extends JpaRepository<OrdemProducao, Long> {

}
