package com.projeto04.Av1.entities;

import com.projeto04.Av1.entities.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "acompanhamento")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AcompanhamentoPedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acompanhamentoPedidoId", nullable = false)
    private Long acompanhamentoId;

    @Column(name = "pedidoId", nullable = false)
    private Long pedidoId;

    @Column(name = "usuarioId", nullable = false)
    private Long usuarioId;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "dataAtualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    public AcompanhamentoPedido(Long usuarioId, Long pedidoId, StatusPedido status) {
        this.usuarioId = usuarioId;
        this.pedidoId = pedidoId;
        this.status = status;
        this.dataAtualizacao = LocalDateTime.now();
    }
}
