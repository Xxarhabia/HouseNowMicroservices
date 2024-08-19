package com.msara.post.controllers;

import com.msara.post.entities.PostEntity;
import com.msara.post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<?> createPost(@RequestBody PostEntity post) {
        try {
            if (post == null) {
                throw new RuntimeException("Post data is null");
            }
            return ResponseEntity.status(201).body(postService.createPost(post));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostByid(@PathVariable Long id) {
        try {
            if (id == null) {
                throw new RuntimeException("Id value is null");
            }
            return ResponseEntity.status(200).body(postService.findPostById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllPost() {
        try {
            return ResponseEntity.status(200).body(postService.findAllPost());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePostById(@PathVariable Long id, @RequestBody PostEntity post) {
        try {
            if (id == null) {
                throw new RuntimeException("Id value is null");
            }
            if (post == null) {
                throw new RuntimeException("Post data is null");
            }
            return ResponseEntity.status(200).body(postService.updatePostById(id, post));
        } catch (Exception ex) {
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }
}
