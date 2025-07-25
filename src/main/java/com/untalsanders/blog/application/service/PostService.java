package com.untalsanders.blog.application.service;

import com.untalsanders.blog.domain.exception.PostNotFoundException;
import com.untalsanders.blog.domain.model.Post;
import com.untalsanders.blog.domain.repository.PostRepository;
import com.untalsanders.blog.domain.usecase.RetrievePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements RetrievePostUseCase {
    private final PostRepository postRepository;

    @Autowired
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
