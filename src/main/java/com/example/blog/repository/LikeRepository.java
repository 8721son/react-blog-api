package com.example.blog.repository;

import com.example.blog.domain.entity.Likes;
import com.example.blog.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LikeRepository extends JpaRepository<Likes,Integer> {

}
