package com.projeto04.Av1.interfacefeign;

import com.projeto04.Av1.entities.CarrinhoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "grupo1.carrinhodecompra", url = "10.136.36.167:8080", path = "/api/carrinho")
public interface CarrinhoFeignClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<CarrinhoDTO> findById(@PathVariable int id);
}
