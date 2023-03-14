package com.example.blog.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import com.example.blog.domain.dto.response.PostDTO;
import com.example.blog.domain.dto.response.PostListDTO;

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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx; // 인덱스
    private String title; // 글 제목
    private String thumbnail; // 썸네일
    private String content; // 내용
    private String summary; // 요약
    private int userIdx; // 작성한 유저 인덱스
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;

    public PostDTO toDTO(){
        PostDTO dto = PostDTO.builder()
                            .idx(idx)
                            .title(title)
                            .content(content)
                            .userIdx(userIdx)
                            .thumbnail(thumbnail)
                            .build();
        return dto;
    }

    public PostListDTO toListDTO(){
        PostListDTO dto = PostListDTO.builder()
                            .idx(idx)
                            .title(title)
                            .createDate(createDate)
                            .userIdx(userIdx)
                            .summary(summary)
                            .thumbnail(thumbnail)
                            .build();
        return dto;
    }
}
