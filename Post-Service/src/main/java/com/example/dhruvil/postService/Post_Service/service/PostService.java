package com.example.dhruvil.postService.Post_Service.service;

import com.example.dhruvil.postService.Post_Service.Advices.ApiResponse;
import com.example.dhruvil.postService.Post_Service.dto.PostDto;
import com.example.dhruvil.postService.Post_Service.entity.PostEntity;
import com.example.dhruvil.postService.Post_Service.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public ResponseEntity<PostDto> createPost(PostDto postDto, String email) {
        PostEntity postEntity = modelMapper.map(postDto, PostEntity.class);
        postEntity.setEmail(email);
//        log.info("Post Entity: {}", postEntity);
        PostEntity savedPost = postRepository.save(postEntity);
        PostDto savedPostDto = modelMapper.map(savedPost, PostDto.class);
        return ResponseEntity.status(201).body(savedPostDto);
    }

    public ResponseEntity<List<PostDto>> getAllPost() {
        List<PostEntity> postEntityList = postRepository.findAll();
        List<PostDto> postDtoList = postEntityList.stream().map(postEntity -> modelMapper.map(postEntity, PostDto.class)).toList();
        return ResponseEntity.ok(postDtoList);
    }

    public ResponseEntity<PostDto> getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        PostDto postDto = modelMapper.map(postEntity, PostDto.class);
        return ResponseEntity.ok(postDto);
    }
}
