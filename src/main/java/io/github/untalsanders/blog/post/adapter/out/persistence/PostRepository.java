package io.github.untalsanders.blog.post.adapter.out.persistence;

import io.github.untalsanders.blog.post.adapter.out.persistence.crud.PostCrudRepository;
import io.github.untalsanders.blog.post.adapter.out.persistence.entity.PostEntity;
import io.github.untalsanders.blog.post.adapter.out.persistence.mapper.PostMapper;
import io.github.untalsanders.blog.post.application.port.out.PostRepositoryPort;
import io.github.untalsanders.blog.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository implements PostRepositoryPort {

    private final PostCrudRepository postCrudRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostRepository(PostCrudRepository postCrudRepository, PostMapper postMapper) {
        this.postCrudRepository = postCrudRepository;
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> getAll() {
        List<PostEntity> postEntityList = postCrudRepository.findAll();
        return postMapper.toPosts(postEntityList);
    }

    @Override
    public Post getById(Long hotelId) {
        return postCrudRepository.findById(hotelId).map(postMapper::entityToDomain).orElse(null);
    }

    @Override
    public Post save(Post post) {
        PostEntity postEntity = postMapper.domainToEntity(post);
        return postMapper.entityToDomain(postCrudRepository.save(postEntity));
    }

    @Override
    public Post update(Post post) {
        PostEntity postEntity = postMapper.domainToEntity(getById(post.getId()));
        postEntity.setId(post.getId());
        postEntity.setTitle(post.getTitle());
        postEntity.setDescription(post.getDescription());
        return save(postMapper.entityToDomain(postEntity));
    }

    @Override
    public void delete(Long postId) {
        Post post = getById(postId);
        postCrudRepository.deleteById(post.getId());
    }
}
