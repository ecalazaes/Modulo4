package com.senac.ecalazaes.VendasEletronico.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendas_id")
    private Long id;

    @Column(name = "vendas_data")
    private LocalDate data;

    @Column(name = "vendas_total")
    private double total;

    @OneToMany(mappedBy = "venda")
    private Set<ItemVenda> itensVenda;

    public Venda() {
    }

    public Venda(Long id, LocalDate data, double total) {
        this.id = id;
        this.data = data;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
