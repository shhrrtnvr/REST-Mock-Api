package com.shhrrtnvr.restest.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private String title;
    private String body;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

}
