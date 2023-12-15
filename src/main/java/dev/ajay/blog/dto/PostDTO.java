package dev.ajay.blog.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostDTO {
    private Long id;

    private String title;
    private String content;
    private LocalDate createdAt;

    // New field for URL-friendly title
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

    public PostDTO(Long id, String title, String content, LocalDate createdAt, String urlTitle) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDate.now();
        this.urlTitle = urlTitle;
    }

    public PostDTO() {
    }
}
