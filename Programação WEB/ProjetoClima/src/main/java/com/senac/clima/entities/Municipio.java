package com.senac.clima.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipio_id", nullable = false)
    private int id;

    @Column(name = "municipio_nome", nullable = false)
    private String nome;

    @Column(name = "municipio_status", nullable = false)
    private int status;

    public Municipio() {
    }

    public Municipio(int id, String nome, int status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        Municipio municipio = (Municipio) o;
        return Objects.equals(id, municipio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
