package com.projeto04.Av1.dto;

import com.projeto04.Av1.entities.enums.StatusPedido;

import java.time.LocalDateTime;


public class AcompanhamentoPedidoDTO {

    private StatusPedido status;
    private LocalDateTime dataAtualizacao;

    public AcompanhamentoPedidoDTO() {
    }

    public AcompanhamentoPedidoDTO(StatusPedido status, LocalDateTime dataAtualizacao) {
        this.status = status;
        this.dataAtualizacao = dataAtualizacao;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
