package org.estsoft.blogcrudassignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.estsoft.blogcrudassignment.dto.comment.CommentResponse;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="article_id", nullable = false)
    private Long articleId;

    @Column(name="body", nullable = false)
    private String body;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    public CommentResponse toResponse() {
        return new CommentResponse(id, body, createdAt);
    }

    public Comment(Long articleId, String body) {
        this.articleId = articleId;
        this.body = body;
    }
}
