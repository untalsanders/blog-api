package io.github.untalsanders.blog.infrastructure.web.rest.controller;

import io.github.untalsanders.blog.application.service.PostService;
import io.github.untalsanders.blog.domain.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPostById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }
}
