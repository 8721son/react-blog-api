package com.example.blog.repository;

import com.example.blog.domain.entity.Post;
import com.example.blog.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Integer> {

}
