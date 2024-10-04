package com.projeto04.Av1.configs;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.StatusPedido;
import com.projeto04.Av1.repositories.AcompanhamentoPedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instancias implements CommandLineRunner {

    private AcompanhamentoPedidoRepository repository;

    public Instancias(AcompanhamentoPedidoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
    // Cria e salva acompanhamentos de pedidos para teste
        repository.deleteAll();

        AcompanhamentoPedido pedido1 = new AcompanhamentoPedido(1L, StatusPedido.POSTAGEM);

        repository.save(pedido1);
    }
}
