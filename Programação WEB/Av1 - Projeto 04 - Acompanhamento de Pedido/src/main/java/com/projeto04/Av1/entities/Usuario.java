package com.projeto04.Av1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private int id;

    @Column(name = "usuario_nome", nullable = false)
    private String nome;

    @Column(name = "usuario_sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "usuario_cpf", nullable = false)
    private String cpf;

    @Column(name = "usuario_email", nullable = false)
    private String email;

    @Column(name = "usuario_senha", nullable = false)
    private String senha;

    @Column(name = "usuario_endereco", nullable = false)
    private String endereco;

    @Column(name = "usuario_telefone", nullable = false)
    private String telefone;

    @Column(name = "usuario_status", nullable = false)
    private int status;

}
