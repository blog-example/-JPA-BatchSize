package com.example.np1.service;

import com.example.np1.dto.CommentDto;
import com.example.np1.dto.PostDto;
import com.example.np1.entity.Comment;
import com.example.np1.entity.Post;
import com.example.np1.repository.PostRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

  @PersistenceContext
  private final EntityManager entityManager;

  private final PostRepository postRepository;

  public List<PostDto> getPosts() {
    EntityGraph<Post> graph = entityManager.createEntityGraph(Post.class);
    graph.addSubgraph(("comments"));

    List<Post> posts = entityManager.createQuery("SELECT p FROM Post p", Post.class)
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();

    List<PostDto> postDtos = new ArrayList<>();
    for (int i = 0; i < posts.size(); i++) {
      Post post = posts.get(i);
      List<Comment> comments = post.getComments(); // N + 1에서 N에 해당

      List<CommentDto> commentDtos = new ArrayList<>();
      for (Comment comment: comments) {
        commentDtos.add(CommentDto.of(comment, post.getPostId()));
      }

      postDtos.add(PostDto.of(post, commentDtos));
    }

    return postDtos;
  }

}
