package com.senac.empresa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Projeto")
public class Projeto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_id", nullable = false)
    private int id;

    @Column(name = "projeto_descricao", nullable = false)
    private String descricao;

    @Column(columnDefinition =  "DATETIME", name = "projeto_data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(columnDefinition =  "DATETIME", name = "projeto_data_fim", nullable = false)
    private LocalDateTime dataFim;

    @Column(columnDefinition =  "BIGINT", name = "projeto_orcamento", nullable = false)
    private Long orcamento;

    @Column(name = "projeto_status", nullable = false)
    private Integer status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public Projeto() {
    }

    public Projeto(int id, String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, Long orcamento, Integer status, Empresa empresa) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.orcamento = orcamento;
        this.status = status;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Long getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Long orcamento) {
        this.orcamento = orcamento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return id == projeto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
