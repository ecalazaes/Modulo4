package com.github.ecalazaes.ProjetoModalBack.services;

import com.github.ecalazaes.ProjetoModalBack.entities.User;
import com.github.ecalazaes.ProjetoModalBack.repositories.UserRepostiory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepostiory userRepository;

    public UserService(UserRepostiory userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
       return userRepository.findAll();
    }
}
