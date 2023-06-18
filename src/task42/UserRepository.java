package com.example.task42;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<com.example.task42.User, Long> {
    @Query("SELECT p FROM User p WHERE CONCAT(p.firstname, ' ', p.lastname, ' ', p.age, ' ', p.number) LIKE %?1%")
    List<User> search(String keyword);
}

