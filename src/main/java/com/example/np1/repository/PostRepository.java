package com.example.np1.repository;

import com.example.np1.entity.Post;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
  @EntityGraph(value = "post-with-comments")
  List<Post> findAll();
}
