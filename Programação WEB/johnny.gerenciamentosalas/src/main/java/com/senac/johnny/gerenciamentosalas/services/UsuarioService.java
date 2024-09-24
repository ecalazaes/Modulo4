package com.senac.johnny.gerenciamentosalas.services;

import com.senac.johnny.gerenciamentosalas.entities.Usuario;
import com.senac.johnny.gerenciamentosalas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario listarPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
    }

    public void deletarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(int id , Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com o ID: " + id));
        usuario.setId(id);
        return usuarioRepository.save(usuarioExistente);
    }
}
