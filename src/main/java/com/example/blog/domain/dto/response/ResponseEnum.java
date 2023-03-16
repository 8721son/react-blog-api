package com.example.blog.domain.dto.response;

import lombok.Getter;

@Getter
public enum ResponseEnum {

    JOIN_SUCCESS(200,"회원가입에 성공했습니다."),
    USER_ID_DUPLICATION(-1,"이미 사용중인 아이디입니다."),
    POST_SAVE_SUCCESS(200,"게시물 저장에 성공했습니다."),
    POST_SELECT_ALL_SUCCESS(200,"게시물 전체 조회에 성공했습니다."),
    POST_SELECT_SUCCESS(200,"게시물 단건 조회에 성공했습니다."),
    LIKE_SAVE_SUCCESS(200,"좋아요 저장에 성공했습니다."),
    LIKE_CANCEL_SUCCESS(-1,"좋아요 취소에 성공했습니다."),
    POST_DELETE_SUCCESS(200,"게시물 삭제에 성공했습니다."),
    POST_DELETE_FAIL(-1,"게시물 삭제에 실패했습니다."),
    POST_UPDATE_SUCCESS(200,"게시물 수정에 성공했습니다."),
    MY_SELECT_SUCCESS(200,"마이페이지 조회에 성공했습니다."),
    USER_UPDATE_SUCCESS(200,"유저 정보 수정에 성공했습니다."),
    ;

    private int code;
    private String message;

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message=message;
    }
}
