package org.estsoft.blogcrudassignment.service;

import jakarta.transaction.Transactional;
import org.estsoft.blogcrudassignment.dto.comment.AddCommentRequest;
import org.estsoft.blogcrudassignment.model.Article;
import org.estsoft.blogcrudassignment.model.Comment;
import org.estsoft.blogcrudassignment.repository.BlogRepository;
import org.estsoft.blogcrudassignment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BlogRepository blogRepository;
    public CommentService(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    @Transactional
    public Comment save(Long articleId, AddCommentRequest request) {
        Article article = blogRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Not Found " + articleId));

        Comment comment = new Comment(article.getId(), request.getBody());
        comment = commentRepository.save(comment);
        article.addComment(comment);
        return comment;
    }

    public List<Comment> selectById(Long articleId) {

        Article article = blogRepository.findById(articleId).orElseThrow(()-> new IllegalArgumentException("Not Found " + articleId));
        List<Comment> comments = article.getComments();
        return comments;
    }
}
