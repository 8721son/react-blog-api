package com.example.blog.service;

import com.example.blog.domain.dto.request.JoinCheckDTO;
import com.example.blog.domain.dto.request.JoinRequestDTO;
import com.example.blog.domain.dto.response.MyDTO;
import com.example.blog.domain.dto.response.PostListDTO;
import com.example.blog.domain.dto.response.UserDTO;
import com.example.blog.domain.entity.Likes;
import com.example.blog.domain.entity.Post;
import com.example.blog.domain.entity.User;
import com.example.blog.repository.LikeRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
        
    public boolean check(JoinCheckDTO joinCheckDTO){
        User user = userRepository.findById(joinCheckDTO.getId());
        return user == null;
    }


    @Transactional
    public UserDTO join(JoinRequestDTO joinRequestDTO){
        // User 테이블에 DTO에 보낸 id를 가진 유저가 있는지
        User check = userRepository.findById(joinRequestDTO.getId());
        if(check!=null){
           return null;
        }

        User user = User.builder()
                .id(joinRequestDTO.getId())
                .password(encoder.encode(joinRequestDTO.getPassword()))
                .simpleDesc(joinRequestDTO.getSimpleDesc())
                .profileImage("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png")
                .role("ROLE_USER")
                .build();

        User save = userRepository.save(user);

        return save.toDTO();
    }


    public MyDTO getMy(int userIdx){
        MyDTO myDTO = new MyDTO();
        //내가 쓴 글
        List<Post> post = postRepository.findByUserIdx(userIdx);
        List<PostListDTO> postDTO = 
        post.stream().map(Post::toListDTO).toList();
        for (PostListDTO dto : postDTO) {
            List<Likes> list = likeRepository.findByPostIdx(dto.getIdx());
            dto.setLike(list.size());

            User writer = userRepository.findByIdx(dto.getUserIdx());
            dto.setWriter(writer.toDTO());
        }
        myDTO.setMyPostList(postDTO);

        //내가 좋아요 한 글
        List<Likes> likeList =likeRepository.findByUserIdx(userIdx);
        // likelist ->for문 -> postIdx로 post조회 List<Post>
        List<Post> temp = new ArrayList<>();
        for (Likes like : likeList) {
            Post likePost = postRepository.findByIdx(like.getPostIdx());
            temp.add(likePost);            
        }

        List<PostListDTO> likePostList = 
                temp.stream().map(Post::toListDTO).toList();

        for (PostListDTO dto : likePostList) {
            List<Likes> list = likeRepository.findByPostIdx(dto.getIdx());
            dto.setLike(list.size());

            User writer = userRepository.findByIdx(dto.getUserIdx());
            dto.setWriter(writer.toDTO());
        }
        myDTO.setLikePostList(likePostList);
        return myDTO;
    }

}
