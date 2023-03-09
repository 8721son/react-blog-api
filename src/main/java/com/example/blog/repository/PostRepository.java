package com.example.blog.repository;

import com.example.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepository extends JpaRepository<Post,Integer> {

}
