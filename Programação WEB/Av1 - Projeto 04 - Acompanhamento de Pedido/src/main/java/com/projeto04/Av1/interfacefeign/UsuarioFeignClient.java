package com.projeto04.Av1.interfacefeign;

import com.projeto04.Av1.entities.CarrinhoDTO;
import com.projeto04.Av1.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "cadastro", url = "10.136.36.103:8080", path = "/usuario")
public interface UsuarioFeignClient {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id);
}
