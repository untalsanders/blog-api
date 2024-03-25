package io.github.untalsanders.blog.post.util;

import io.github.untalsanders.blog.post.adapter.out.persistence.crud.PostCrudRepository;
import io.github.untalsanders.blog.post.adapter.out.persistence.entity.PostEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateDB implements InitializingBean {

    private final PostCrudRepository postCrudRepository;

    @Autowired
    public PopulateDB(PostCrudRepository postCrudRepository) {
        this.postCrudRepository = postCrudRepository;
    }

    @Override
    public void afterPropertiesSet() {
        postCrudRepository.save(new PostEntity(1L, "Post #1", "Description Post #1"));
        postCrudRepository.save(new PostEntity(2L, "Post #2", "Description Post #1"));
    }
}
