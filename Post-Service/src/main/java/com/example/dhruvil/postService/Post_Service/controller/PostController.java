package com.example.dhruvil.postService.Post_Service.controller;

import com.example.dhruvil.postService.Post_Service.dto.PostDto;
import com.example.dhruvil.postService.Post_Service.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<PostDto> createPost(@RequestBody(required = true) PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping("/getAllPost")
    public ResponseEntity<List<PostDto>> getAllPost() {
        return postService.getAllPost();
    }
}
