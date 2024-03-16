package org.estsoft.blogcrudassignment.controller;

import org.estsoft.blogcrudassignment.dto.comment.AddCommentRequest;
import org.estsoft.blogcrudassignment.dto.comment.CommentResponse;
import org.estsoft.blogcrudassignment.model.Comment;
import org.estsoft.blogcrudassignment.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService service;
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping("/comments/{articleId}")
    public ResponseEntity<CommentResponse> save(@PathVariable Long articleId, @RequestBody AddCommentRequest request) {

        try {
            Comment comment = service.save(articleId, request);
            return ResponseEntity.status(HttpStatus.CREATED).body(comment.toResponse());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/comments/{articleId}")
    public ResponseEntity <List<CommentResponse>> selectById(@PathVariable Long articleId) {
        try {
            List<Comment> comments = service.selectById(articleId);
            List<CommentResponse> commentResponses = comments.stream()
                    .map(x -> new CommentResponse(x.getId(), x.getBody(), x.getCreatedAt())).toList();

            return ResponseEntity.ok(commentResponses);
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
