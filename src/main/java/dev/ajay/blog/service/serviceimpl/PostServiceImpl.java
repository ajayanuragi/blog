package dev.ajay.blog.service.serviceimpl;

import dev.ajay.blog.dto.PostDTO;
import dev.ajay.blog.model.Post;
import dev.ajay.blog.repository.PostRepository;
import dev.ajay.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getAllPost() {
        System.out.println(postRepository.findAll());
        return postRepository.findAll();
    }

    @Override
    public void createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setCreatedAt(postDTO.getCreatedAt());
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setUrlTitle(setUrlTitle(postDTO));
        postRepository.save(post);

        System.out.println(post);
    }

    @Override
    public Optional<Post> findPost(Long postId) throws Exception {
       Optional<Post> post =  postRepository.findById(postId);
       if (post.isEmpty()) {
           throw new Exception("Post not found");
       }
        return post;
    }

    @Override
    public void updatePost(PostDTO postDTO) throws Exception {
        Post post = postRepository.findById(postDTO.getId())
                .orElseThrow(() -> new Exception("Post not found"));
        if(postDTO.getTitle() != null){
            post.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null){
            post.setContent(postDTO.getContent());
        }
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    private String setUrlTitle(PostDTO postDTO) {
        String lowercaseTitle = postDTO.getTitle().toLowerCase();
        String urlFriendlyTitle = lowercaseTitle.replaceAll("\\s", "-");
        return urlFriendlyTitle.replaceAll("[^a-zA-Z0-9-]", "");
    }


}
