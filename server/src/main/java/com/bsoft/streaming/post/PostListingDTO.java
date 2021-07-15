package com.bsoft.streaming.post;

import com.bsoft.streaming.author.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListingDTO {
    private Long id;
    private String title;
    private LocalDateTime postedAt;
    private AuthorDTO author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostListingDTO that = (PostListingDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(postedAt, that.postedAt) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, postedAt, author);
    }
}
