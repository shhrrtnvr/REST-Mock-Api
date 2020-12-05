package com.shhrrtnvr.restest.db.service;

import com.shhrrtnvr.restest.db.repository.PostRepository;
import com.shhrrtnvr.restest.dto.PostDto;
import com.shhrrtnvr.restest.mapper.PostMapper;
import com.shhrrtnvr.restest.db.entity.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository posts;

    public PostDto addPost(PostDto postDto) {
        Post post = PostMapper.fromPostDto(postDto);
        post = posts.save(post);
        postDto.setPostId(post.getPostId());
        return postDto;
    }

    public PostDto findById(Long postId) {
        return PostMapper.fromPost(posts.findById(postId).get());
    }

    public boolean deleteById(Long postId) {
        posts.deleteById(postId);
        return true;
    }

    public List<PostDto> getAll() {
        List<PostDto> postList = new ArrayList<>();
        posts.findAll().forEach(p -> postList.add(PostMapper.fromPost(p)));
        return postList;
    }

    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = PostMapper.fromPostDto(postDto);
        post.setPostId(postId);
        posts.save(post);
        postDto.setPostId(postId);
        return postDto;
    }
}
