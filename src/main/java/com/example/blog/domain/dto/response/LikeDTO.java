package com.example.blog.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LikeDTO {
    private int postIdx;
    private int userIdx;
}
