package com.msara.post.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "posts")
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private List<String> image;

    @Column(name = "date_insert")
    private LocalDateTime dateInsert;

    @Column(name = "date_modify")
    private LocalDateTime dateModify;

    @Column(name = "like_id")
    private Long likeId;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "share_id")
    private Long shareId;
}
