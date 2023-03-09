package com.example.blog.controller;

import com.example.blog.config.auth.PrincipalDetails;
import com.example.blog.domain.dto.request.LikeDTO;
import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.request.PostUpdateRequestDTO;
import com.example.blog.domain.dto.response.*;
import com.example.blog.service.PostService;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/post")
@RequiredArgsConstructor
public class PostController {

}
