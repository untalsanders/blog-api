package io.github.untalsanders.blog.post.application.service;

import io.github.untalsanders.blog.post.adapter.out.persistence.PostRepository;
import io.github.untalsanders.blog.post.application.exception.SuchElementAlreadyExistsException;
import io.github.untalsanders.blog.post.application.exception.NoSuchElementFoundException;
import io.github.untalsanders.blog.post.application.port.in.PostServicePort;
import io.github.untalsanders.blog.post.domain.Post;
import io.github.untalsanders.blog.post.adapter.out.persistence.PostRepository;
import io.github.untalsanders.blog.post.application.port.in.PostServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService implements PostServicePort {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getById(Long postId) {
        Post post = postRepository.getById(postId);
        if (Objects.isNull(post)) {
            throw new NoSuchElementFoundException(String.format("Post %s not found", postId));
        }
        return post;
    }

    @Override
    public Post save(Post post) {
        Post postToSave = postRepository.getById(post.getId());
        if (Objects.nonNull(postToSave)) {
            throw new SuchElementAlreadyExistsException(String.format("Post %s it already exists", postToSave));
        }
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        getById(post.getId());
        return postRepository.update(post);
    }

    @Override
    public void delete(Long postId) {
        getById(postId);
        postRepository.delete(postId);
    }
}
