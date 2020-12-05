package com.shhrrtnvr.restest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long commentId;
    private String description;
    private Long postId;
}
