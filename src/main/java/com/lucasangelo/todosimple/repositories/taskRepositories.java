package com.lucasangelo.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface taskRepositories extends JpaRepository<task, Long> {

    List<task> findByUser_Id( Long id);

    //Optional<task> findById( Long id);

    //@Query (value = "SELECT t FROM task t WHERE t.user.id = :id")
    // List<task> findByUser_id(@Param ("id") Long id);
    
}
