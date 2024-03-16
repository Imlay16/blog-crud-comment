package org.estsoft.blogcrudassignment.dto.article;

import lombok.Getter;

@Getter
public class UpdateArticleRequest {
    private String title;
    private String content;
}
