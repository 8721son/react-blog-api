package com.example.blog.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.blog.domain.dto.response.LikeDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private int postIdx; // 게시물 인덱스
    private int userIdx; // 유저 인덱스

    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;


    public LikeDTO toDTO(){
        return LikeDTO.builder()
            .postIdx(postIdx)
            .userIdx(userIdx)
            .build();
    }
}
