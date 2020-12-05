package com.shhrrtnvr.restest.db.repository;

import com.shhrrtnvr.restest.db.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
