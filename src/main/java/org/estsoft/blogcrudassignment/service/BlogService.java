package org.estsoft.blogcrudassignment.service;

import jakarta.transaction.Transactional;
import org.estsoft.blogcrudassignment.dto.article.AddArticleRequest;
import org.estsoft.blogcrudassignment.dto.article.UpdateArticleRequest;
import org.estsoft.blogcrudassignment.model.Article;
import org.estsoft.blogcrudassignment.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository repository;
    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    public Article selectById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found " + id));
    }

    public List<Article> selectAll() {
        return repository.findAll();
    }

    public Article save(AddArticleRequest request) {
        Article article = new Article(request.getTitle(), request.getTitle());
        return repository.save(article);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = repository.findById(id).orElse(new Article());

        String title = article.getTitle();
        String content = article.getContent();

        if (title != request.getTitle()) {
            title = request.getTitle();
        }

        if (content != request.getContent()) {
            content = request.getContent();
        }

        article.update(title, content);
        return article;
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
