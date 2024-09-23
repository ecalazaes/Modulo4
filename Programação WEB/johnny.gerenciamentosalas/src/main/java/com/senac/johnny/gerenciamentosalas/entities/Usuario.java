package com.senac.johnny.gerenciamentosalas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private int id;

    @Column(name = "usuario_nome")
    private String nome;

    @Column(name = "usuario_matricula")
    private String matricula;

    @Column(name = "usuario_tipo")
    private int tipo;

    @Column(name = "usuario_status", nullable = false)
    private int status;

    @Column(name = "usuario_log_data_criacao", nullable = false)
    private LocalDateTime logDaCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_lod_responsavel_id")
    private Usuario usuario;

    public Usuario() {
    }

    public Usuario(int id, String nome, String matricula, int tipo, int status, LocalDateTime logDaCriacao) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.tipo = tipo;
        this.status = status;
        this.logDaCriacao = logDaCriacao;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getLogDaCriacao() {
        return logDaCriacao;
    }

    public void setLogDaCriacao(LocalDateTime logDaCriacao) {
        this.logDaCriacao = logDaCriacao;
    }


    @JsonBackReference
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
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
