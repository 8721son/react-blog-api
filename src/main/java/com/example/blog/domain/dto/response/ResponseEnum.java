package com.example.blog.domain.dto.response;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    JOIN_SUCCESS(200,"회원가입에 성공했습니다."),
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
