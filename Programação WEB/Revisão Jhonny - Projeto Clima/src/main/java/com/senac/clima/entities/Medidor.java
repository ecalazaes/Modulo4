package com.senac.clima.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "medidor")
public class Medidor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medidor_id", nullable = false)
    private int id;

    @Column(name = "medidor_status", nullable = false, length = 45)
    private int status;

    @ManyToOne
    @JoinColumn(name = "municipio_id", nullable = false)
    private Municipio municipio;

    public Medidor() {
    }

    public Medidor(int id, int status, Municipio municipio) {
        this.id = id;
        this.status = status;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medidor medidor = (Medidor) o;
        return Objects.equals(id, medidor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
