package com.example.blog.domain.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyDTO {
    private List<PostListDTO> myPostList;
    private List<PostListDTO> likePostList;
}
