package com.shhrrtnvr.restest.db;

import com.shhrrtnvr.restest.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface PostRepository extends CrudRepository<Post, UUID> {

}
