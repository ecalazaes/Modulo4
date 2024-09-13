package com.senac.ecalazaes.VendasEletronico.services;

import com.senac.ecalazaes.VendasEletronico.entities.ItemVenda;
import com.senac.ecalazaes.VendasEletronico.repositories.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VendaService {

    private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Map<String, Integer> listarProdutosVendidos() {

        List<ItemVenda> itensVenda = vendaRepository.findAll().stream()
                .flatMap(venda -> venda.getItensVenda().stream())
                .toList();

        Map<String, Integer> resultado = new HashMap<>();
        for (ItemVenda item : itensVenda) {
            String produtoNome = item.getProduto().getNome();
            resultado.merge(produtoNome, item.getQuantidade(), Integer::sum);
        }
        return resultado;
    }

    public Map<String, Double> valorVendasPorCategoria() {
        // Obtém todos os itens de venda
        List<ItemVenda> itensVenda = vendaRepository.findAll().stream()
                .flatMap(venda -> venda.getItensVenda().stream())
                .toList();

        // Mapa para armazenar o valor total das vendas por categoria
        Map<String, Double> resultado = new HashMap<>();

        // Calcula o valor total das vendas por categoria
        for (ItemVenda item : itensVenda) {
            String categoriaNome = item.getProduto().getCategoria().getNome();
            double valorVenda = item.getPrecoUnitario() * item.getQuantidade();

            // Atualiza o total das vendas para a categoria
            resultado.merge(categoriaNome, valorVenda, Double::sum);
        }

        return resultado;
    }
}
