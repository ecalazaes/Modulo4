package com.github.ecalazaes.ProjetoModalBack.config;

import com.github.ecalazaes.ProjetoModalBack.entities.User;
import com.github.ecalazaes.ProjetoModalBack.repositories.UserRepostiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class instancias implements CommandLineRunner {

    private UserRepostiory userRepository;

    public instancias(UserRepostiory userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Erick Calazães", 33);
        User user2 = new User(null, "Erick da Silva", 50);
        User user3 = new User(null, "Daniele", 20);
        User user4 = new User(null, "Ronaldo", 35);
        User user5 = new User(null, "Ronaldo", 35);

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
}
