package org.estsoft.blogcrudassignment.repository;

import org.estsoft.blogcrudassignment.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
}
