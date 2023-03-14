package com.example.blog.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDTO {
    private String title; // 글 제목
    private String thumbnail; // 썸네일
    private String content; // 내용
    private String summary; // 요약
}
