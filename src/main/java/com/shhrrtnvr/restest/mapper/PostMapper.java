package com.shhrrtnvr.restest.mapper;

import com.shhrrtnvr.restest.dto.PostDto;
import com.shhrrtnvr.restest.db.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {
    public static Post fromPostDto(PostDto postDto){
        return Post.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .build();
    }
    public static PostDto fromPost(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .body(post.getBody())
                .title(post.getTitle())
                .comments(post.getComments()
                        .stream()
                        .map(CommentMapper::fromComment)
                        .collect(Collectors.toList()))
                .build();
    }
}
