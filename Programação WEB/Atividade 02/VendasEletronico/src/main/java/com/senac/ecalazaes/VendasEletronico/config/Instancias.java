package com.senac.ecalazaes.VendasEletronico.config;

import com.senac.ecalazaes.VendasEletronico.entities.Categoria;
import com.senac.ecalazaes.VendasEletronico.entities.ItemVenda;
import com.senac.ecalazaes.VendasEletronico.entities.Produto;
import com.senac.ecalazaes.VendasEletronico.entities.Venda;
import com.senac.ecalazaes.VendasEletronico.repositories.CategoriaRepository;
import com.senac.ecalazaes.VendasEletronico.repositories.ItemVendaRepository;
import com.senac.ecalazaes.VendasEletronico.repositories.ProdutoRepository;
import com.senac.ecalazaes.VendasEletronico.repositories.VendaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instancias implements CommandLineRunner {

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private VendaRepository vendaRepository;
    private ItemVendaRepository itemVendaRepository;

    public Instancias(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, VendaRepository vendaRepository, ItemVendaRepository itemVendaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria1 = new Categoria(null, "Eletrônicos");
        Categoria categoria2 = new Categoria(null, "Variedades");
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));


        Produto produto1 = new Produto(null, "Samsung Galaxy S23", 3500, categoria1);
        Produto produto2 = new Produto(null, "Copo Stanley", 120, categoria2);
        Produto produto3 = new Produto(null, "Relógio G-Shock", 900, categoria1);
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));


        Venda venda1 = new Venda(null, LocalDate.now(), 0);
        Venda vendaRealizada1 = vendaRepository.save(venda1);

        Venda venda2 = new Venda(null, LocalDate.now(), 0);
        Venda vendaRealizada2 = vendaRepository.save(venda2);

        ItemVenda itemVenda1 = new ItemVenda(null, 2, produto1.getPreco(), vendaRealizada1, produto1);
        ItemVenda itemVenda2 = new ItemVenda(null, 5, produto2.getPreco(), vendaRealizada2, produto2);
        itemVendaRepository.saveAll(Arrays.asList(itemVenda1, itemVenda2));

    }
}
