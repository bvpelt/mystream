package com.bsoft.streaming.controller;

import com.bsoft.streaming.author.AuthorNotFoundException;
import com.bsoft.streaming.comment.CommentDTO;
import com.bsoft.streaming.comment.CommentInputDTO;
import com.bsoft.streaming.comment.CommentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CommentController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final CommentService service;

    @MessageMapping("/posts/{id}/comment/create")
    @SendTo("/topic/posts/{id}/comment/created")
    public CommentDTO createComment(@DestinationVariable("id") Long postId, CommentInputDTO comment) {
        return service.createComment(postId, comment);
    }

    @MessageExceptionHandler
    @SendToUser("/topic/error")
    public String handleException(AuthorNotFoundException ex) {
        logger.debug("Author not found", ex);
        return "The given author was not found";
    }
}
