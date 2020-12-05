package com.shhrrtnvr.restest.db.service;

import com.shhrrtnvr.restest.db.entity.Comment;
import com.shhrrtnvr.restest.db.entity.Post;
import com.shhrrtnvr.restest.db.repository.CommentRepository;
import com.shhrrtnvr.restest.db.repository.PostRepository;
import com.shhrrtnvr.restest.dto.CommentDto;
import com.shhrrtnvr.restest.mapper.CommentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentDto addComment(CommentDto commentdto, Long postId) {
        Post post = postRepository.findById(postId).get();
        Comment comment = CommentMapper.fromCommentDto(commentdto);
        comment.setPost(post);
        comment = commentRepository.save(comment);
        return CommentMapper.fromComment(comment);
    }

    public CommentDto getCommentById(Long commentId) {
        return CommentMapper.fromComment(commentRepository.findById(commentId).get());
    }

    public List<CommentDto> getComments(Long postId) {
        return postRepository.findById(postId).get()
                .getComments()
                .stream()
                .map(CommentMapper::fromComment)
                .collect(Collectors.toList());
    }

}
