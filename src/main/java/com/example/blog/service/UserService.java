package com.example.blog.service;

import com.example.blog.domain.dto.request.JoinCheckDTO;
import com.example.blog.domain.dto.request.JoinRequestDTO;
import com.example.blog.domain.dto.response.UserDTO;
import com.example.blog.domain.entity.User;
import com.example.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

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
        // User 테이블에 DTO에 보낸 id를 가진 유저가 있는지
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
