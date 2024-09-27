package io.github.untalsanders.blog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Post {
    private Long id;
    private String title;
    private String content;
}
