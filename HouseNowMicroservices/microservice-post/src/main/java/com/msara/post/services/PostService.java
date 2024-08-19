package com.msara.post.services;

import com.msara.post.entities.PostEntity;
import com.msara.post.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostEntity createPost(PostEntity post) {
        try {
            PostEntity newPost = new PostEntity();

            newPost.setDescription(post.getDescription());
            newPost.setImage(post.getImage());
            newPost.setDateInsert(LocalDateTime.now());
            newPost.setDateModify(LocalDateTime.now());

            return postRepository.save(newPost);
        } catch (Exception ex) {
            throw new RuntimeException("Error al crear el post: " +ex.getMessage());
        }
    }

    public PostEntity findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<PostEntity> findAllPost() {
        return postRepository.findAll();
    }

    public PostEntity updatePostById(Long id, PostEntity post) {
         PostEntity postFound = findPostById(id);

         if (post.getDescription() != null) {
            postFound.setDescription(post.getDescription());
         }
         if (post.getImage() != null) { //TODO traer la imagenes previas para añadir mas
            postFound.setImage(post.getImage());
         }
         postFound.setDateModify(LocalDateTime.now());

         return postRepository.save(postFound);
    }
}
