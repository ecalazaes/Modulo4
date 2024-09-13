package com.senac.ecalazaes.VendasEletronico.services;

import com.senac.ecalazaes.VendasEletronico.entities.Categoria;
import com.senac.ecalazaes.VendasEletronico.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
