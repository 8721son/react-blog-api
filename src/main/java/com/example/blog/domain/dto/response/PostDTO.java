package com.example.blog.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PostDTO {
    private int idx;
    private String title;
    private String content;
    private String thumbnail;
    private int userIdx;
}
