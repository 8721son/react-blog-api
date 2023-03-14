package com.example.blog.repository;

import com.example.blog.domain.entity.Likes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes,Integer> {
    // select * from likes where postIdx=:postIdx
    List<Likes> findByPostIdx(int postIdx);
}
