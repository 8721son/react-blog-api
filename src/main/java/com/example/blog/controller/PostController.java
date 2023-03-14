package com.example.blog.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.blog.config.auth.PrincipalDetails;
import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.response.PostDTO;
import com.example.blog.domain.dto.response.PostListDTO;
import com.example.blog.domain.dto.response.ResponseDTO;
import com.example.blog.domain.dto.response.ResponseEnum;
import com.example.blog.service.PostService;



@RestController
@RequestMapping("/v1/api/post")
@RequiredArgsConstructor
public class PostController {
    
    private final PostService postService;

    // localhost:8081/v1/api/post
    @PostMapping("")
    public HttpEntity<ResponseDTO> save(@RequestBody PostSaveRequestDTO postSaveRequestDTO,
                                        Authentication authentication){
            PrincipalDetails principal = (PrincipalDetails) 
                                            authentication.getPrincipal();
            int userIdx = principal.getUser().getIdx();
            PostDTO dto = postService.save(postSaveRequestDTO, userIdx);

            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.POST_SAVE_SUCCESS, dto),HttpStatus.OK);
    }


    @GetMapping("")
    public HttpEntity<ResponseDTO> getPosts(){
        List<PostListDTO> dto = postService.getPosts();

        return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.POST_SELECT_ALL_SUCCESS, dto),HttpStatus.OK);
    }

}
