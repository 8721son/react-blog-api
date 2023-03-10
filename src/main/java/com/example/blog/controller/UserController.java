package com.example.blog.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.blog.domain.dto.request.JoinRequestDTO;
import com.example.blog.domain.dto.response.ResponseDTO;
import com.example.blog.domain.dto.response.ResponseEnum;
import com.example.blog.domain.dto.response.UserDTO;
import com.example.blog.service.UserService;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public HttpEntity<ResponseDTO> join(@RequestBody JoinRequestDTO joinRequestDTO){
        UserDTO dto = userService.join(joinRequestDTO);
        if(dto==null){
            return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.USER_ID_DUPLICATION, null),HttpStatus.OK);
        }

        return new ResponseEntity<>(
                new ResponseDTO(
                    ResponseEnum.JOIN_SUCCESS, dto),HttpStatus.OK);
    }

}
