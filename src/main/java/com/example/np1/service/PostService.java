package com.example.np1.service;

import com.example.np1.dto.CommentDto;
import com.example.np1.dto.PostDto;
import com.example.np1.entity.Comment;
import com.example.np1.entity.Post;
import com.example.np1.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;

  public List<PostDto> getPosts() {
    List<Post> posts = postRepository.findAll(); // 최초 로딩시에 두 번째 쿼리까지 동시에 발생

    List<PostDto> postDtos = new ArrayList<>();
//    for (int i = 0; i < posts.size(); i++) {  // comment에 접근이 없어도 추가 쿼리 발생
//      Post post = posts.get(i);
//      List<Comment> comments = post.getComments();
//
//      List<CommentDto> commentDtos = new ArrayList<>();
//      for (Comment comment : comments) {
//        commentDtos.add(CommentDto.of(comment, post.getPostId()));
//      }
//
//      postDtos.add(PostDto.of(post, commentDtos));
//    }

    return postDtos;
  }

  public PostDto getPost(long id) {
    Post post = postRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("no matched post with pid: " + id));

    List<CommentDto> commentDtos = new ArrayList<>();
    for (Comment comment : post.getComments()) {
      commentDtos.add(CommentDto.of(comment, post.getPostId()));
    }

    return PostDto.of(post, commentDtos);
  }

}
