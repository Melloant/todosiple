package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasangelo.todosimple.models.user;

@Repository
public interface useRepositories extends JpaRepository<user, Long> {

    
}
