package io.github.untalsanders.blog.infrastructure.persistence;

import io.github.untalsanders.blog.domain.model.Post;
import io.github.untalsanders.blog.domain.repository.PostRepository;
import io.github.untalsanders.blog.infrastructure.persistence.crud.PostCrudRepository;
import io.github.untalsanders.blog.infrastructure.persistence.entity.PostEntity;
import io.github.untalsanders.blog.infrastructure.persistence.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPostRepository implements PostRepository {

    private final PostCrudRepository postCrudRepository;
    private final PostMapper postMapper;

    @Autowired
    public JpaPostRepository(PostCrudRepository postCrudRepository, PostMapper postMapper) {
        this.postCrudRepository = postCrudRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> postEntityList = (List<PostEntity>) postCrudRepository.findAll();
        return postMapper.toPosts(postEntityList);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postCrudRepository.findById(id).map(postMapper::entityToDomain);
    }
}
