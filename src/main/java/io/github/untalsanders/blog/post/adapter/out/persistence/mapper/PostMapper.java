package io.github.untalsanders.blog.post.adapter.out.persistence.mapper;

import io.github.untalsanders.blog.post.adapter.out.persistence.entity.PostEntity;
import io.github.untalsanders.blog.post.domain.Post;
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
            @Mapping(source="description", target="description"),
    })
    Post entityToDomain(PostEntity postEntity);

    List<Post> toPosts(List<PostEntity> postEntities);

    @InheritInverseConfiguration
    PostEntity domainToEntity(Post post);
}
