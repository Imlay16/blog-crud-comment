package org.estsoft.blogcrudassignment.controller;

import org.estsoft.blogcrudassignment.dto.article.AddArticleRequest;
import org.estsoft.blogcrudassignment.dto.article.ArticleResponse;
import org.estsoft.blogcrudassignment.dto.article.UpdateArticleRequest;
import org.estsoft.blogcrudassignment.model.Article;
import org.estsoft.blogcrudassignment.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {

    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/api/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> selectById(@PathVariable Long id) {

        try {

            Article article = service.selectById(id);
            return ResponseEntity.ok(article.toResponse());
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/articles")
    @ResponseBody
    public ResponseEntity<List<ArticleResponse>> selectAll() {
        List<Article> articles = service.selectAll();
        List<ArticleResponse> articleResponses = articles.stream().map(x -> new ArticleResponse(x.getId(), x.getTitle(), x.getContent(), x.getComments())).toList();
        return ResponseEntity.ok(articleResponses);
    }

    @PostMapping("/api/articles")
    @ResponseBody
    public ResponseEntity<ArticleResponse> save(@RequestBody AddArticleRequest request) {
        Article article = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(article.toResponse());
    }

    @PutMapping("/api/articles/{id}")
    @ResponseBody
    public ResponseEntity<ArticleResponse> update(@PathVariable Long id, @RequestBody UpdateArticleRequest request) {
        Article article = service.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(article.toResponse());
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
