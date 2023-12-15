package dev.ajay.blog.repository;

import dev.ajay.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
