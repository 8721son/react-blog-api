package com.example.blog.repository;

import com.example.blog.domain.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LikeRepository extends JpaRepository<Likes,Integer> {

}
