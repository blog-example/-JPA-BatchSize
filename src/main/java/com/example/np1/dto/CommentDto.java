package com.example.np1.dto;

import com.example.np1.entity.Comment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDto {
  private long commentId;
  private String comment;
  private long postId;

  public static CommentDto of (Comment comment, long postId) {
    return new CommentDto(comment.getCommentId(), comment.getComment(), postId);
  }
}
