package org.estsoft.blogcrudassignment.dto.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.estsoft.blogcrudassignment.model.Comment;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
    private List<Comment> comments;
}
