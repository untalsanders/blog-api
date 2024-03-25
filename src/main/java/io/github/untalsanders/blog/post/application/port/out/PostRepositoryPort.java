package io.github.untalsanders.blog.post.application.port.out;

import io.github.untalsanders.blog.post.domain.Post;

import java.util.List;

public interface PostRepositoryPort {
    List<Post> getAll();
    Post getById(Long hotelId);
    Post save(Post hotel);
    Post update(Post hotel);
    void delete(Long hotelId);
}
