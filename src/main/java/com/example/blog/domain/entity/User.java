package com.example.blog.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.blog.domain.dto.response.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx; // 인덱스
    private String id; // 사용자 id
    private String password; // 비밀번호
    private String simpleDesc; // 한줄소개
//    @ColumnDefault("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
    private String profileImage; // 프로필이미지
    private String role; // 스프링 시큐리티 (user,manager,admin)

    @CreationTimestamp // insert 자동 생성
    private LocalDateTime createDate; //생성일
    @UpdateTimestamp // update 자동 생성
    private LocalDateTime updateDate; //수정일


    public UserDTO toDTO(){
        return UserDTO.builder()
        .idx(idx)
        .id(id)
        .simpleDesc(simpleDesc)
        .profileImage(profileImage)
        .build();
    }
}
