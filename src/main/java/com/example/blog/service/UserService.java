package com.example.blog.service;

import com.example.blog.domain.dto.request.JoinCheckDTO;
import com.example.blog.domain.dto.request.JoinRequestDTO;
import com.example.blog.domain.dto.request.UserChangeDTO;
import com.example.blog.domain.dto.response.MyDTO;
import com.example.blog.domain.dto.response.PostListDTO;
import com.example.blog.domain.dto.response.UserDTO;
import com.example.blog.domain.entity.Likes;
import com.example.blog.domain.entity.Post;
import com.example.blog.domain.entity.User;
import com.example.blog.repository.LikeRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    public boolean check(JoinCheckDTO joinCheckDTO){
        User user = userRepository.findById(joinCheckDTO.getId());
        return user == null;
    }


    @Transactional
    public UserDTO join(JoinRequestDTO joinRequestDTO){
        User check = userRepository.findById(joinRequestDTO.getId());
        if(check!=null){
           return null;
        }

        User user = User.builder()
                .id(joinRequestDTO.getId())
                .password(encoder.encode(joinRequestDTO.getPassword()))
                .simpleDesc(joinRequestDTO.getSimpleDesc())
                .profileImage("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .role("ROLE_USER")
                .build();

        User save = userRepository.save(user);

        return save.toDTO();
    }




}
