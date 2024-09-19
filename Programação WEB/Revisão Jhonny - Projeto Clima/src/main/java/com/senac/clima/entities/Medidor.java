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
    private Integer id;

    @Column(name = "medidor_status", nullable = false, length = 45)
    private int status;

    @Column(name = "munucipio_id", nullable = false)
    private int municipioId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(int municipioId) {
        this.municipioId = municipioId;
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
