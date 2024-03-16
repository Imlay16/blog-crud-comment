package org.estsoft.blogcrudassignment.controller;

import org.estsoft.blogcrudassignment.model.Article;
import org.estsoft.blogcrudassignment.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {
    private final BlogService service;
    public ViewController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public String showAll(Model model) {
        List<Article> articles = service.selectAll();
        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Article article = service.selectById(id);
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/new-article")
    public String showArticle(@RequestParam(required = false) Long id, Model model) {

        if (id == null) {
            model.addAttribute("article", new Article());
        }
        else {
            model.addAttribute("article", service.selectById(id));
        }
        return "newArticle";
    }
}
