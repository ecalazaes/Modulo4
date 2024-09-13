package com.senac.ecalazaes.VendasEletronico.controllers;


import com.senac.ecalazaes.VendasEletronico.services.VendaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping("/produtos")
    public Map<String, Integer> listarProdutosVendidos() {
        return vendaService.listarProdutosVendidos();
    }

    @GetMapping("/categorias")
    public Map<String, Double> valorVendasPorCategoria() {
        return vendaService.valorVendasPorCategoria();
    }
}
