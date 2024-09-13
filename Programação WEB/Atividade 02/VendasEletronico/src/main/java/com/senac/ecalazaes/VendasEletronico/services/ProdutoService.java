package com.senac.ecalazaes.VendasEletronico.services;

import com.senac.ecalazaes.VendasEletronico.entities.Produto;
import com.senac.ecalazaes.VendasEletronico.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
       return produtoRepository.findAll();
    }
}
