package com.example.blog.domain.dto.response;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    JOIN_SUCCESS(200,"회원가입에 성공했습니다."),
    USER_ID_DUPLICATION(-1,"이미 사용중인 아이디입니다."),
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
