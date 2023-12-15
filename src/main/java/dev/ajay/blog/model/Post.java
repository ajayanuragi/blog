package dev.ajay.blog.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate createdAt;
    private String urlTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getUrlTitle() {
        return urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }
    @PrePersist
    public void prePersist() {
        this.createdAt  = LocalDate.now();
    }

    public Post(Long id, String title, String content, LocalDate createdAt, String urlTitle) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDate.now();
        this.urlTitle = urlTitle;
    }

    public Post() {
    }
}
