package com.example.blog.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO {
    private String password;
    private String simpleDesc;
    private String profileImage;
}
