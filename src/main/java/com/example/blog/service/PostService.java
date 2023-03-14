package com.example.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.response.PostDTO;
import com.example.blog.domain.entity.Post;
import com.example.blog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostDTO save(PostSaveRequestDTO postSaveRequestDTO,int userIdx){
        Post post = Post.builder()
                        .title(postSaveRequestDTO.getTitle())
                        .content(postSaveRequestDTO.getContent())
                        .thumbnail(postSaveRequestDTO.getThumbnail())
                        .summary(postSaveRequestDTO.getSummary())
                        .userIdx(userIdx)
                        .build();

        Post savedPost = postRepository.save(post);
        return savedPost.toDTO();
    }
}
