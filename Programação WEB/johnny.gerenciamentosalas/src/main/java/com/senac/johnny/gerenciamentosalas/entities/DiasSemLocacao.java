package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "dias_sem_alocacao")
public class DiasSemLocacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dias_sem_alocacao_id", nullable = false)
    private int id;

    @Column(name = "dias_sem_alocacao_data")
    private LocalDate data;

    @Column(name = "dias_sem_alocacao_dia_semana")
    private int diaSemana;

    @Column(name = "dias_sem_alocacao_horario_inicio")
    private LocalTime horarioInicio;

    @Column(name = "dias_sem_alocacao_horario_fim")
    private LocalTime horarioFim;

    @Column(name = "dias_sem_alocacao_status")
    private int status;

    @OneToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    public DiasSemLocacao() {
    }

    public DiasSemLocacao(int id, LocalDate data, int diaSemana, LocalTime horarioInicio, LocalTime horarioFim, int status) {
        this.id = id;
        this.data = data;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.status = status;
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

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiasSemLocacao that = (DiasSemLocacao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
