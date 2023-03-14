package com.example.blog.domain.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostListDTO {
    private int idx;
    private String title;
    private String summary;
    private String thumbnail;

    private int userIdx; // 작성자 인덱스
    private int like;
    private UserDTO writer;

    private LocalDateTime createDate;
}
