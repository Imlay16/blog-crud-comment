package org.estsoft.blogcrudassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.estsoft.blogcrudassignment.dto.article.ArticleResponse;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content", nullable = false)
    private String content;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToMany
    @Column(name="comment_id")
    private List<Comment> comments = new ArrayList<>();

    public ArticleResponse toResponse() {
        return new ArticleResponse(id, title, content, comments);
    }
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
