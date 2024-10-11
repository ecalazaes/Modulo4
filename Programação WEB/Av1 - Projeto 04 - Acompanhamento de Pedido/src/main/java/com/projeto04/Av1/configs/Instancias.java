package com.projeto04.Av1.configs;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.enums.StatusPedido;
import com.projeto04.Av1.repositories.AcompanhamentoPedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class Instancias implements CommandLineRunner {

    private final AcompanhamentoPedidoRepository acompanhamentoPedidoRepository;

    @Override
    public void run(String... args) throws Exception {

//        acompanhamentoPedidoRepository.deleteAll();
//        AcompanhamentoPedido pedido1 = new AcompanhamentoPedido(1L, StatusPedido.POSTAGEM);
//        AcompanhamentoPedido pedido2 = new AcompanhamentoPedido(2L, StatusPedido.PREPARACAO);
//        AcompanhamentoPedido pedido3 = new AcompanhamentoPedido(3L, StatusPedido.COLETA);
//        acompanhamentoPedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
    }
}
