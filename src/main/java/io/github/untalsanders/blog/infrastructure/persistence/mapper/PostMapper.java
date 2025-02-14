package io.github.untalsanders.blog.infrastructure.persistence.mapper;

import io.github.untalsanders.blog.domain.model.Post;
import io.github.untalsanders.blog.infrastructure.persistence.entity.PostEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring")
public interface PostMapper {

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="title", target="title"),
            @Mapping(source="content", target="content"),
            @Mapping(source="author", target="author")
    })
    Post entityToDomain(PostEntity postEntity);

    List<Post> toPosts(List<PostEntity> postEntities);

    @InheritInverseConfiguration
    PostEntity domainToEntity(Post post);
}
