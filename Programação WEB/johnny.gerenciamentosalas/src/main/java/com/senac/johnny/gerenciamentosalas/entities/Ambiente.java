package com.senac.johnny.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ambiente")
public class Ambiente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ambiente_id", nullable = false, length = 11)
    private int id;

    @Column(name = "ambiente_descricao", length = 45)
    private String descricao;

    @Column(name = "ambiente_andar", length = 11)
    private int andar;

    @Column(name = "ambiente_tipo", length = 45)
    private String tipo;

    @Column(name = "ambiente_numero_pcs", length = 11)
    private int numeroPcs;

    @Column(name = "ambiente_capacidade", length = 11)
    private int capacidade;

    @Column(name = "ambiente_status", length = 11)
    private int status;

    @OneToOne(mappedBy = "ambiente")
    private DiasSemLocacao diasSemLocacao;

    public Ambiente() {
    }

    public Ambiente(int id, String descricao, int andar, String tipo, int numeroPcs, int capacidade, int status) {
        this.id = id;
        this.descricao = descricao;
        this.andar = andar;
        this.tipo = tipo;
        this.numeroPcs = numeroPcs;
        this.capacidade = capacidade;
        this.status = status;
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

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroPcs() {
        return numeroPcs;
    }

    public void setNumeroPcs(int numeroPcs) {
        this.numeroPcs = numeroPcs;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ambiente ambiente = (Ambiente) o;
        return Objects.equals(id, ambiente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
