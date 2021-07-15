package com.bsoft.streaming.repositories;

import com.bsoft.streaming.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorUsername(String username);
}
