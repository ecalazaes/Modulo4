package com.github.ecalazaes.ProjetoModalBack.repositories;

import com.github.ecalazaes.ProjetoModalBack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepostiory extends JpaRepository<User, Long> {

    List<User> findByNomeContaining(String nome);
    List<User> findByIdade(int idade);
}
