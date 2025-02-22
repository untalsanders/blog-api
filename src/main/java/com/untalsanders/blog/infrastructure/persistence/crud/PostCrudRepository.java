package com.untalsanders.blog.infrastructure.persistence.crud;

import com.untalsanders.blog.infrastructure.persistence.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostCrudRepository extends CrudRepository<PostEntity, Long> {
}
