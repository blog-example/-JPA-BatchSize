package com.example.np1.repository;

import com.example.np1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
  @Query(value = "SELECT p FROM Post p JOIN FETCH p.comments")
  List<Post> findAll();
}
