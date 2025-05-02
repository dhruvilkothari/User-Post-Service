package com.example.dhruvil.postService.Post_Service.repository;

import com.example.dhruvil.postService.Post_Service.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
