package com.example.np1.dto;

import com.example.np1.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostDto {
  private long postId;
  private String title;
  private String content;
  private List<CommentDto> comments;

  public static PostDto of (Post post, List<CommentDto> comments) {
    return new PostDto(post.getPostId(), post.getTitle(), post.getContent(), comments);
  }
}

