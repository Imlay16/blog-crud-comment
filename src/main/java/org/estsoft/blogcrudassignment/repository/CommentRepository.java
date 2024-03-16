package org.estsoft.blogcrudassignment.repository;

import org.estsoft.blogcrudassignment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
