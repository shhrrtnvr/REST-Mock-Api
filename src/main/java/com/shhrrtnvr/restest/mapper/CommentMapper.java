package com.shhrrtnvr.restest.mapper;

import com.shhrrtnvr.restest.db.entity.Comment;
import com.shhrrtnvr.restest.dto.CommentDto;

public class CommentMapper {
    public static Comment fromCommentDto(CommentDto commentDto) {
        return Comment.builder()
                .commentId(commentDto.getCommentId())
                .description(commentDto.getDescription())
                .build();
    }

    public static CommentDto fromComment(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .description(comment.getDescription())
                .postId(comment.getPost().getPostId())
                .build();
    }
}
