package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "planejamento_alocacao")
public class PlanejamentoAlocacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planejamento_alocacao_id", length = 11)
    private int id;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String observacao;
    private int status;
}
