package io.github.untalsanders.blog.infrastructure.persistence.crud;

import io.github.untalsanders.blog.infrastructure.persistence.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostCrudRepository extends CrudRepository<PostEntity, Long> {
}
