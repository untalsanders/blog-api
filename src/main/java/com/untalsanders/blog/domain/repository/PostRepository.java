package com.untalsanders.blog.domain.repository;

import com.untalsanders.blog.domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    /**
     * Retrieve all <code>Post</code>s from the data store.
     *
     * @return <code>Collection</code> of <code>Post</code>s
     */
    List<Post> findAll();

    /**
     * Retrieve a <code>Post</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>Post</code> if found
     */
    Optional<Post> findById(Long id);
}
