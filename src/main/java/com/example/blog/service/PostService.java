package com.example.blog.service;

import com.example.blog.domain.dto.request.LikeDTO;
import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.request.PostUpdateRequestDTO;
import com.example.blog.domain.dto.response.PostDTO;
import com.example.blog.domain.dto.response.PostListDTO;
import com.example.blog.domain.entity.Likes;
import com.example.blog.domain.entity.Post;
import com.example.blog.domain.entity.User;
import com.example.blog.repository.LikeRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

}
