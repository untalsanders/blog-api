package io.github.untalsanders.blog.post.application.port.in;

import io.github.untalsanders.blog.post.domain.Post;

import java.util.List;

public interface PostServicePort {
    List<Post> getAll();
    Post getById(Long postId);
    Post save(Post post);
    Post update(Post post);
    void delete(Long postId);
}
