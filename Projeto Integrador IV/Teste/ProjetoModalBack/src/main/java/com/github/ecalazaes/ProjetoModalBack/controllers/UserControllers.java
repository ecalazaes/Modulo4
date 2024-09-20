package com.github.ecalazaes.ProjetoModalBack.controllers;

import com.github.ecalazaes.ProjetoModalBack.entities.User;
import com.github.ecalazaes.ProjetoModalBack.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllers {

    private UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("nome")
    public ResponseEntity<List<User>> getUserByNome(@RequestParam String nome) {
        List<User> users = userService.getUserByName(nome);
        return ResponseEntity.ok(users);
    }

    @GetMapping("idade")
    public ResponseEntity<List<User>> getUserByIdade(@RequestParam int idade) {
        List<User> users = userService.getUserByIdade(idade);
        return ResponseEntity.ok(users);
    }
}
