package dev.ajay.blog.controller;

import dev.ajay.blog.dto.PostDTO;
import dev.ajay.blog.model.Post;
import dev.ajay.blog.service.serviceimpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostServiceImpl postService;
    //Read
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPost(),HttpStatus.OK);
    }
    //Create
    @PostMapping("/posts/post")
    public ResponseEntity<String> createNewPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);
        System.out.println(postDTO);

        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }
    //Read
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Optional<Post>> getPost(@PathVariable Long postId) throws Exception {
        Optional<Post> post = postService.findPost(postId);
        if (post.isPresent()) {
            return new ResponseEntity<>(post, HttpStatus.OK);
        }
        throw new Exception("Post not found");
    }
    //Update
    @PutMapping("/posts/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId,@RequestBody PostDTO postDTO) throws Exception{
        findPost(postId);
        postService.updatePost(postDTO);

        return new ResponseEntity<>("Post Updated Successfully", HttpStatus.OK);
    }

    private void findPost(Long postId) throws Exception {
        Post post = postService.findPost(postId)
                .orElseThrow(() -> new Exception("No post found"));
    }

    //Delete

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) throws Exception {
        findPost(postId);
        postService.deletePost(postId);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }


}
