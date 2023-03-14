package com.example.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.domain.dto.request.PostSaveRequestDTO;
import com.example.blog.domain.dto.response.PostDTO;
import com.example.blog.domain.dto.response.PostListDTO;
import com.example.blog.domain.entity.Likes;
import com.example.blog.domain.entity.Post;
import com.example.blog.domain.entity.User;
import com.example.blog.repository.LikeRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final LikeRepository likeRepository;

    private final UserRepository userRepository;

    public PostDTO save(PostSaveRequestDTO postSaveRequestDTO,int userIdx){
        Post post = Post.builder()
                        .title(postSaveRequestDTO.getTitle())
                        .content(postSaveRequestDTO.getContent())
                        .thumbnail(postSaveRequestDTO.getThumbnail())
                        .summary(postSaveRequestDTO.getSummary())
                        .userIdx(userIdx)
                        .build();

        Post savedPost = postRepository.save(post);
        return savedPost.toDTO();
    }

    public List<PostListDTO> getPosts(){
        List<PostListDTO> posts = postRepository.findAll()
                                            .stream()
                                            .map(Post::toListDTO)
                                            .toList();
        // List<PostListDTO> dto = new ArrayList<>();
        // for (Post p : posts) {
        //     dto.add(p.toListDTO());            
        // }

        for (PostListDTO postListDTO : posts) {
            // like -> like 테이블에서 좋아요가 눌러진 데이터를 전체조회해서 개수만
            List<Likes> list = likeRepository.findByPostIdx(postListDTO.getIdx());
            postListDTO.setLike(list.size());
            
            // writer -> dto에서 작성자 userIdx를 이용해서 User엔티티를 조회
            User writer = userRepository.findByIdx(postListDTO.getUserIdx());
            postListDTO.setWriter(writer.toDTO());
        }

        return posts;
    }


}
