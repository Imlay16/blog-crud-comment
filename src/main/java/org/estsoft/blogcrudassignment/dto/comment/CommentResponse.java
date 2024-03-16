package org.estsoft.blogcrudassignment.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.estsoft.blogcrudassignment.model.Comment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private Long id;
    private String body;
    private LocalDateTime createdAt;
}
