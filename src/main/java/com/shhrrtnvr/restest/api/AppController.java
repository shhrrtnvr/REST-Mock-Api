package com.shhrrtnvr.restest.api;

import com.shhrrtnvr.restest.model.Post;
import com.shhrrtnvr.restest.service.PostService;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AppController {
    private PostService postService;

    @GetMapping("/posts")
    public List<JSONObject> getAll() {
        return postService.list();
    }

    @GetMapping("/posts/{uuid}")
    public Post getByID(@PathVariable("uuid") String uuid) {
        return postService.findById(UUID.fromString(uuid));
    }

    @PostMapping("/posts")
    public Post post(@RequestBody JSONObject json) {
        return postService.addPost(new Post(json));
    }

    @DeleteMapping("/posts")
    public boolean deleteAll() {
        return postService.deleteAll();
    }

    @DeleteMapping("/posts/{uuid}")
    public boolean deleteById(@PathVariable("uuid") String uuid) {
        return postService.deleteById(UUID.fromString(uuid));
    }
}
