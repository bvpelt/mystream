package com.bsoft.streaming.author;

import lombok.Data;

import java.util.Objects;

@Data
public class DetailedAuthorDTO extends AuthorDTO {
    private String bio;

    public DetailedAuthorDTO(Long id, String username, String bio) {
        super(id, username);
        this.bio = bio;
    }

    public DetailedAuthorDTO() {
        this(null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DetailedAuthorDTO that = (DetailedAuthorDTO) o;
        return Objects.equals(bio, that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bio);
    }
}
