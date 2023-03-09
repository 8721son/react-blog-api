package com.example.blog.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDTO {
    int code;
    String message;
    Object content;

    public ResponseDTO(ResponseEnum responseEnum,Object content){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.content = content;
    }
}
