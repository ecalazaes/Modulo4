package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "reserva_alocacao")
public class ReservaAlocacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_alocacao_id", length = 11, nullable = false)
    private int id;

    @Column(name = "reserva_alocacao_justificativa", length = 300)
    private String justificativa;

    @Column(name = "reserva_alocacao_data")
    private LocalDate data;

    @Column(name = "reserva_alocacao_hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "reserva_alocacao_hora_fim")
    private LocalTime horaFim;

    @Column(name = "reserva_alocacao_status", length = 11)
    private int status;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @Column(length = 11)
    private Usuario usuario;

    public ReservaAlocacao() {
    }

    public ReservaAlocacao(int id, String justificativa, LocalDate data, LocalTime horaInicio, LocalTime horaFim, int status, Usuario usuario) {
        this.id = id;
        this.justificativa = justificativa;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.status = status;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaAlocacao that = (ReservaAlocacao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
