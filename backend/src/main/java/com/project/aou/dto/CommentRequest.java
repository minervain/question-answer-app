package com.project.aou.dto;


import lombok.Data;

@Data
public class CommentRequest {

    Long id;
    Long userId;
    Long postId;
    String Text;
}
