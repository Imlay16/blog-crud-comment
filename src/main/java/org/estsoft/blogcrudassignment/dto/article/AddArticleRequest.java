package org.estsoft.blogcrudassignment.dto.article;

import lombok.Getter;

@Getter
public class AddArticleRequest {
    private String title;
    private String content;
}
