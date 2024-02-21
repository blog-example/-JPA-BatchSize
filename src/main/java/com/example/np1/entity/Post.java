package com.example.np1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = "post-with-comments",  // 이 Graph를 가리키는 id
        attributeNodes = @NamedAttributeNode("comments") // 연관관계가 있는 필드
)
@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private long postId;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  @OneToMany(mappedBy = "post")
  private List<Comment> comments = new ArrayList<>();

  public void addComment(Comment comment) {
    if (!comments.contains(comment)) {
      comments.add(comment);
      comment.addPost(this);
    }
  }
}
