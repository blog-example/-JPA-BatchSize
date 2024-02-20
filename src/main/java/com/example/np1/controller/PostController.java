package com.example.np1.controller;


import com.example.np1.dto.PostDto;
import com.example.np1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

  private final PostService postService;

  @GetMapping("/post")
  public List<PostDto> getOrder() {
    return postService.getPosts();
  }
}
