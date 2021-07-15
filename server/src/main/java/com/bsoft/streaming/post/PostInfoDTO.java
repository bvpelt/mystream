package com.bsoft.streaming.post;

import com.bsoft.streaming.author.AuthorDTO;
import com.bsoft.streaming.comment.CommentDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class PostInfoDTO extends PostListingDTO {
    private String content;
    private List<CommentDTO> comments;

    public PostInfoDTO() {
    }

    public PostInfoDTO(Long id, String title, LocalDateTime postedAt, AuthorDTO author, String content, List<CommentDTO> comments) {
        super(id, title, postedAt, author);
        this.content = content;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PostInfoDTO that = (PostInfoDTO) o;
        return Objects.equals(content, that.content) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content, comments);
    }
}
