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
import com.example.blog.domain.dto.request.PostUpdateRequestDTO;
import com.example.blog.domain.dto.response.LikeDTO;
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

    @GetMapping("/{postIdx}")
    public HttpEntity<ResponseDTO> getPost(@PathVariable int postIdx,Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) 
                                        authentication.getPrincipal();
        int userIdx = principal.getUser().getIdx();

        PostDTO dto = postService.getPost(postIdx, userIdx);

        return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.POST_SELECT_SUCCESS, dto),HttpStatus.OK);
    }


    @PostMapping("/like/{postIdx}")
    public HttpEntity<ResponseDTO> like(@PathVariable int postIdx, Authentication authentication){
        // postIdx, userIdx -> Like 조회
        // 있으면 삭제 , 없으면 insert
        PrincipalDetails principal = (PrincipalDetails) 
                                    authentication.getPrincipal();
        int userIdx = principal.getUser().getIdx();
        // dto -> insert LikeDTO 객체가 있을거고, delete -> null
        LikeDTO dto = postService.like(postIdx, userIdx);

        if(dto==null){
            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.LIKE_CANCEL_SUCCESS, dto),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.LIKE_SAVE_SUCCESS, dto),HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{postIdx}")
    public HttpEntity<ResponseDTO> deletePost(@PathVariable int postIdx,
                                                Authentication authentication){
        PrincipalDetails principal = (PrincipalDetails) 
                                authentication.getPrincipal();
        int userIdx = principal.getUser().getIdx();
        boolean bool = postService.deletePost(postIdx, userIdx);
        if(bool){
            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.POST_DELETE_SUCCESS, bool),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.POST_DELETE_FAIL, bool),HttpStatus.OK);
        }
    }

    @PutMapping("/update/{postIdx}")
    public HttpEntity<ResponseDTO> updatePost(@PathVariable int postIdx
                                            ,Authentication authentication
                                            ,@RequestBody PostUpdateRequestDTO postUpdateRequestDTO){
        PrincipalDetails principal = (PrincipalDetails) 
        authentication.getPrincipal();
        int userIdx = principal.getUser().getIdx();

        PostDTO dto = postService.updatePost(postIdx, userIdx, postUpdateRequestDTO);
        return new ResponseEntity<>(
            new ResponseDTO(
                ResponseEnum.POST_UPDATE_SUCCESS, dto),HttpStatus.OK);
    }
}
