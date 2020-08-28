package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.repository.RepositoryComment;
import com.wolox.challenge.service.CommentService;
import com.wolox.challenge.service.dto.CommentDto;
import com.wolox.challenge.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    RepositoryComment repositoryComment;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public CommentDto add(CommentDto commentDto) {
        return commentMapper.toCommentDto(repositoryComment.save(commentMapper.toComment(commentDto)));
    }
}
