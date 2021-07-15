package com.bsoft.streaming.post;

import com.bsoft.streaming.author.AuthorNotFoundException;
import com.bsoft.streaming.author.AuthorService;
import com.bsoft.streaming.comment.CommentService;
import com.bsoft.streaming.repositories.AuthorRepository;
import com.bsoft.streaming.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final CommentService commentService;
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    public List<PostListingDTO> findAll() {
        return repository.findAll().stream().map(this::getListingDTO).collect(Collectors.toList());
    }

    public List<PostListingDTO> findByAuthor(String username) {
        return repository
                .findAllByAuthorUsername(username).stream()
                .map(this::getListingDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostInfoDTO findOne(Long id) {
        return repository.findById(id).map(this::getInfoDTO).orElseThrow(PostNotFoundException::new);
    }

    @Transactional
    public PostListingDTO save(PostInputDTO post) {
        return getListingDTO(repository.saveAndFlush(new Post(
                null,
                post.getTitle(),
                post.getContent(),
                new ArrayList<>(),
                authorRepository.findById(post.getAuthorId()).orElseThrow(AuthorNotFoundException::new),
                LocalDateTime.now())));
    }

    private PostListingDTO getListingDTO(Post entity) {
        return new PostListingDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getPostedAt(),
                authorService.getDTO(entity.getAuthor()));
    }

    private PostInfoDTO getInfoDTO(Post entity) {
        return new PostInfoDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getPostedAt(),
                authorService.getDTO(entity.getAuthor()),
                entity.getContent(),
                entity.getComments().stream().map(commentService::getDTO).collect(Collectors.toList()));
    }
}
