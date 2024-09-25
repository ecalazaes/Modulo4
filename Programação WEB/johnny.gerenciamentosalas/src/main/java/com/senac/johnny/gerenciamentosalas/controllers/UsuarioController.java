package com.senac.johnny.gerenciamentosalas.controllers;

import com.senac.johnny.gerenciamentosalas.entities.Usuario;
import com.senac.johnny.gerenciamentosalas.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("criar")
    @Transactional
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @GetMapping("listarPorId/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.listarPorId(id);
        return usuario == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuario);
    }

    @DeleteMapping("deletarPorId/{id}")
    @Transactional
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("atualizarPorId/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }
}

