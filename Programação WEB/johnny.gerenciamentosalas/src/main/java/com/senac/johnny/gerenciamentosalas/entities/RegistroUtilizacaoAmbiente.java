package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "registro_utilizacao_ambiente")
public class RegistroUtilizacaoAmbiente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_utilizacao_ambiente_id")
    private int id;

    @Column(name = "registro_utilizacao_ambiente_hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name = "registro_utilizacao_ambiente_hora_saida")
    private LocalDateTime horaSaida;

    @Column(name = "registro_utilizacao_ambiente_status")
    private int status;

    @Column(name = "registro_utilizacao_ambiente_observacao")
    private String observacao;

    @OneToOne
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;

    @ManyToOne
    @JoinColumn(name = "planejamento_alocacao_id")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @OneToOne
    @JoinColumn(name = "usuario_id_retirada", nullable = false)
    private Usuario retirada;

    @OneToOne
    @JoinColumn(name = "usuario_id_devolucao")
    private Usuario devolucao;

    public RegistroUtilizacaoAmbiente() {
    }

    public RegistroUtilizacaoAmbiente(int id, LocalDateTime horaEntrada, LocalDateTime horaSaida, int status, String observacao, Ambiente ambiente, Usuario retirada) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.status = status;
        this.observacao = observacao;
        this.ambiente = ambiente;
        this.retirada = retirada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacao() {
        return planejamentoAlocacao;
    }

    public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        this.planejamentoAlocacao = planejamentoAlocacao;
    }

    public Usuario getRetirada() {
        return retirada;
    }

    public void setRetirada(Usuario retirada) {
        this.retirada = retirada;
    }

    public Usuario getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Usuario devolucao) {
        this.devolucao = devolucao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroUtilizacaoAmbiente that = (RegistroUtilizacaoAmbiente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
