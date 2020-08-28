package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.Comment;
import com.wolox.challenge.service.PostService;
import com.wolox.challenge.service.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {

    @Autowired
    PostService postService;

    public Comment toComment(CommentDto commentDto) {
        return new Comment(
                commentDto.getId(),
                commentDto.getName(),
                commentDto.getEmail(),
                commentDto.getBody(),
                postService.getById(commentDto.getPostId())
        );
    }

    public CommentDto toCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getPost().getId(),
                comment.getName(),
                comment.getEmail(),
                comment.getBody()
        );
    }
}
