package com.example.blog.repository;

import com.example.blog.domain.entity.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
    Post findByIdx(int idx);
    void deleteByIdx(int idx);
    List<Post> findByUserIdx(int userIdx);
}
