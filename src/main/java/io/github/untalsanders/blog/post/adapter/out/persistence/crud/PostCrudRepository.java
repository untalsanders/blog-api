package io.github.untalsanders.blog.post.adapter.out.persistence.crud;

import io.github.untalsanders.blog.post.adapter.out.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCrudRepository extends JpaRepository<PostEntity, Long> {
}
