package org.estsoft.blogcrudassignment.dto.article;

import lombok.Getter;
import org.estsoft.blogcrudassignment.model.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
    }
}
