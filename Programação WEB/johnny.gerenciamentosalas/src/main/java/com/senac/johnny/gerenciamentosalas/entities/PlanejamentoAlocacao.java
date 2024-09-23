package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

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

    public PlanejamentoAlocacao() {
    }

    public PlanejamentoAlocacao(int id, LocalDate data, LocalTime horaInicio, LocalTime horaFim, String observacao, int status, Ambiente ambiente, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.observacao = observacao;
        this.status = status;
        this.ambiente = ambiente;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ReservaAlocacao getReservaAlocacao() {
        return reservaAlocacao;
    }

    public void setReservaAlocacao(ReservaAlocacao reservaAlocacao) {
        this.reservaAlocacao = reservaAlocacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanejamentoAlocacao that = (PlanejamentoAlocacao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
