package com.ecalazaes.Produtos.config;

import com.ecalazaes.Produtos.entities.Produto;
import com.ecalazaes.Produtos.repositories.CategoriaRepository;
import com.ecalazaes.Produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instancias implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {

        produtoRepository.deleteAll();
        categoriaRepository.deleteAll();

       Produto p1 = new Produto(null, "Samsung Galaxy S23", "Smartphone com tela de 6.1 polegadas, câmera tripla de 50 MP, processador Snapdragon 8 Gen 2, e bateria de 4000 mAh.", 5.499);

       Produto p2 = new Produto(null, "Dell Inspiron 15", "Notebook com tela de 15.6 polegadas Full HD, processador Intel Core i7 de 12ª geração, 8 GB de RAM, e 512 GB de SSD.", 4.299);

        Produto p3 = new Produto(null, "LG OLED 55", "Televisão OLED de 55 polegadas com resolução 4K, suporte a HDR10, Dolby Vision e áudio Dolby Atmos.", 7.999);

        Produto p4 = new Produto(null, "Blusa Feminina de Algodão", "Blusa feminina de manga curta feita 100% em algodão, disponível em várias cores, com estampa floral e ajuste confortável.", 89.90);

        Produto p5 = new Produto(null, "Calça Jeans Skinny Masculina", "Calça jeans masculina modelo skinny, em denim azul escuro, com ajuste moderno e confortável. Ideal para uso diário.", 179.90);

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Categoria




    }
}
