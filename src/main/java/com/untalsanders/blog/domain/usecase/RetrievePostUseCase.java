package com.untalsanders.blog.domain.usecase;

import com.untalsanders.blog.domain.model.Post;
import com.untalsanders.blog.domain.exception.PostNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RetrievePostUseCase {
    /**
     * Retrieve a <code>Post</code> by id.
     *
     * @param id the id to search for
     * @return the <code>Post</code> if found
     */
    Optional<Post> getPost(Long id) throws PostNotFoundException;

    /**
     * Retrieve all <code>Post</code>s.
     *
     * @return <code>Collection</code> of <code>Post</code>s
     */
    List<Post> getPosts();
}
