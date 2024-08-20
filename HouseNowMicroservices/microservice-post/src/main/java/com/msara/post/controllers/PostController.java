package com.msara.post.controllers;

import com.msara.post.entities.PostEntity;
import com.msara.post.services.PostService;
import com.msara.post.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private DataUtils dataUtils;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPost(
            @RequestParam("description") String description,
            @RequestParam("image")List<MultipartFile> image) {
        try {
            if (description == null || image == null) {
                throw new RuntimeException("Post data is null");
            }
            List<String> listImageBase64 = dataUtils.parseImageToBase64(image);

            PostEntity post = new PostEntity();
            post.setDescription(description);
            post.setImage(listImageBase64);

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
