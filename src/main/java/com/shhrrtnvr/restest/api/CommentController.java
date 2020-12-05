package com.shhrrtnvr.restest.api;

import com.shhrrtnvr.restest.db.entity.Comment;
import com.shhrrtnvr.restest.db.entity.Post;
import com.shhrrtnvr.restest.db.service.CommentService;
import com.shhrrtnvr.restest.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/posts/{postId}/comments")
    public CommentDto saveComment(@PathVariable("postId") Long postId,
                               @RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto, postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public CommentDto postComment(
            @PathVariable("postId")  Long postId,
            @PathVariable("commentId")  Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> postComment(@PathVariable("postId") Long postId) {
        return commentService.getComments(postId);
    }

}
