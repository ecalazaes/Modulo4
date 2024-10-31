package com.github.ecalazaes.ProjetoTeste03.services;

import com.github.ecalazaes.ProjetoTeste03.entities.User;
import com.github.ecalazaes.ProjetoTeste03.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public User updateById(Long id, User user) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User with id " + id + " not found.");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
