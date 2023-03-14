package com.example.blog.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.response.ResponseDTO;



@RestController
@RequestMapping("/v1/api/post")
@RequiredArgsConstructor
public class PostController {
    

    
    @PostMapping("")
    public HttpEntity<ResponseDTO> save(@RequestBody PostSaveRequestDTO postSaveRequestDTO){

    }

}
