package com.bsoft.streaming.post;

import com.bsoft.streaming.author.Author;
import com.bsoft.streaming.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

    private LocalDateTime postedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(comments, post.comments) && Objects.equals(author, post.author) && Objects.equals(postedAt, post.postedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, comments, author, postedAt);
    }
}
