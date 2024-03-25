package io.github.untalsanders.blog.post.adapter.in.web.controller;

import io.github.untalsanders.blog.post.application.service.PostService;
import io.github.untalsanders.blog.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Post> getById(@PathVariable("hotelId") Long postId) {
        return new ResponseEntity<>(postService.getById(postId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> save(@RequestBody Post post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post post) {
        return new ResponseEntity<>(postService.update(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("postId") Long postId) {
        postService.delete(postId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
