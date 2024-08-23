package rj.senac.br.TestAPI.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
public class Empresa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Long id;

    @NotBlank(message = "Por favor inserir um nome")
    @Column(name = "empresa_nome", nullable = false)
    private String nome;

    @CNPJ
    @Column(name = "empresa_cnpj", unique = true, nullable = false)
    private String cnpj;

    @Email
    @Column(name = "empresa_email", unique = true, nullable = false)
    @NotBlank(message = "Por favor inserir um email")
    private String email;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String cnpj, String email) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
