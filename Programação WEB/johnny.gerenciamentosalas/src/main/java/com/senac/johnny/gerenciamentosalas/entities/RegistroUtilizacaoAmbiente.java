package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbiente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_utilizacao_ambiente_id")
    private Long id;

    @Column(name = "registro_utilizacao_ambiente_hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name = "registro_utilizacao_ambiente_saida")
    private LocalDateTime horaSaida;

    @Column(name = "registro_utilizacao_ambiente_status")
    private int status;

    @Column
    private String observacao;
}
