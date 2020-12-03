package com.shhrrtnvr.restest.service;

import com.shhrrtnvr.restest.db.PostRepository;
import com.shhrrtnvr.restest.model.Post;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.*;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository posts;

    public Post addPost(Post post) {
        return posts.save(post);
    }

    public Post findById(UUID uuid) {
        Post p;
        try{
            p = posts.findById(uuid).get();
        }
        catch(NoSuchElementException e) {
            p = new Post(new JSONObject());
        }
        return p;
    }

    public List<JSONObject> list() {
        List<JSONObject> ret = new ArrayList<JSONObject>();
        posts.findAll().forEach(post -> ret.add(post.jsn()) );
        return ret;
    }

    public boolean deleteAll() {
        posts.deleteAll();
        return true;
    }

    public boolean deleteById(UUID uuid) {
        posts.deleteById(uuid);
        return true;
    }
}
