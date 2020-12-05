package com.shhrrtnvr.restest.api;

import com.shhrrtnvr.restest.dto.PostDto;
import com.shhrrtnvr.restest.db.entity.Post;
import com.shhrrtnvr.restest.db.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getAll() {
        return postService.getAll();
    }

    @GetMapping("/posts/{postId}")
    public PostDto getByID(@PathVariable("postId") Long postId) {
        return postService.findById(postId);
    }

    @PostMapping("/posts")
    public PostDto post(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }
    @PutMapping("/posts/{id}")
    public PostDto put(@RequestBody PostDto postDto, @PathVariable("id") Long id) {
        return postService.updatePost(postDto, id);
    }

    @DeleteMapping("/posts/{postId}")
    public boolean deleteById(@PathVariable("postId") Long postId) {
        return postService.deleteById(postId);
    }
}
