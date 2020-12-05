package com.shhrrtnvr.restest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PostDto {
    private Long postId;
    private String title;
    private String body;
    private List<CommentDto> comments;
}
