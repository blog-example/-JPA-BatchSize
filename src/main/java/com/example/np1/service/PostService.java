package com.example.np1.service;

import com.example.np1.entity.Post;
import com.example.np1.repository.CommentRepository;
import com.example.np1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  public List<Post> getPosts() {
    List<Post> posts = postRepository.findAll();
    posts.stream().forEach((post) -> post.getComments().size());

    return posts;
  }


}
