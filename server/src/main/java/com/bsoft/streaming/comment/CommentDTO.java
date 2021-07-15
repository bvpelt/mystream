package com.bsoft.streaming.comment;

import com.bsoft.streaming.author.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private AuthorDTO author;
    private LocalDateTime postedAt;
}
