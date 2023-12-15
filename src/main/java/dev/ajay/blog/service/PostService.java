package dev.ajay.blog.service;

import dev.ajay.blog.dto.PostDTO;
import dev.ajay.blog.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPost();

    void createPost(PostDTO postDTO);

    Optional<Post> findPost(Long postId) throws Exception;

    void updatePost(PostDTO postDTO) throws Exception;

    void deletePost(Long postId);
}
