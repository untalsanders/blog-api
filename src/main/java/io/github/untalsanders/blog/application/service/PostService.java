package io.github.untalsanders.blog.application.service;

import io.github.untalsanders.blog.domain.exception.PostNotFoundException;
import io.github.untalsanders.blog.domain.model.Post;
import io.github.untalsanders.blog.domain.repository.PostRepository;
import io.github.untalsanders.blog.domain.usecase.RetrievePostUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> getPost(Long id) throws PostNotFoundException {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
