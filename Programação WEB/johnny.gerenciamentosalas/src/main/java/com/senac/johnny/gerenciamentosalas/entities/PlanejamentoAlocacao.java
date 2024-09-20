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
    @Column(name = "planejamento_alocacao_id")
    private int id;

    @Column(name = "planejamento_alocacao_data")
    private LocalDate data;

    @Column(name = "planejamento_alocacao_hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "planejamento_alocacao_hora_fim")
    private LocalTime horaFim;

    @Column(name = "planejamento_alocacao_observacao")
    private String observacao;

    @Column(name = "planejamento_alocacao_status")
    private int status;

    @OneToOne
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "reserva_alocacao_id")
    private ReservaAlocacao reservaAlocacao;
}
