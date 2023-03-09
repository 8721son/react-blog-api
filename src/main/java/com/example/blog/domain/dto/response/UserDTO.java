package com.example.blog.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
    private int idx;
    private String id;
    private String simpleDesc;
    private String profileImage;
}
