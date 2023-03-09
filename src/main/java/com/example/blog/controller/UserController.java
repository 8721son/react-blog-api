package com.example.blog.controller;

import com.example.blog.config.auth.PrincipalDetails;
import com.example.blog.domain.dto.request.JoinCheckDTO;
import com.example.blog.domain.dto.request.JoinRequestDTO;
import com.example.blog.domain.dto.request.UserChangeDTO;
import com.example.blog.domain.dto.response.MyDTO;
import com.example.blog.domain.dto.response.ResponseDTO;
import com.example.blog.domain.dto.response.ResponseEnum;
import com.example.blog.domain.dto.response.UserDTO;
import com.example.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

}
