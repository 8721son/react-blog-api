package com.example.blog.repository;

import com.example.blog.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(String id);
}
