package com.bsoft.streaming.controller;

import com.bsoft.streaming.post.PostListingDTO;
import com.bsoft.streaming.post.PostService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private PostService service;

    @SubscribeMapping("/posts/get")
    public List<PostListingDTO> findAll() {
        return service.findAll();
    }
}
