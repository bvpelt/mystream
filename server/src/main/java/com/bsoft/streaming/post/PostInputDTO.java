package com.bsoft.streaming.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInputDTO {
    private String title;
    private String content;
    private Long authorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostInputDTO that = (PostInputDTO) o;
        return Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, authorId);
    }
}
