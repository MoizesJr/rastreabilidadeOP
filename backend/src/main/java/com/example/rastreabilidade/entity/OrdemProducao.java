package com.example.rastreabilidade.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrdemProducao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String numeroOrdem;
  private String numeroLote;

  @Enumerated(EnumType.STRING)
  private EnumTipoFarinha farinhaTipo;

  private String marcaFarinha;

  @ElementCollection
  private List<String> notasUsadas = new ArrayList<>();

  private Double pesoTotal;
  private String statusOp;

}
