package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.Post;
import com.wolox.challenge.service.UserService;
import com.wolox.challenge.service.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    public Post toPost(PostDto postDto) {
        return new Post(
                postDto.getId(),
                postDto.getTitle(),
                postDto.getBody(),
                null,
                userService.getUserById(postDto.getUserId())
        );
    }

    public PostDto toPostDto(Post post) {
        return new PostDto(
                post.getUser().getId(),
                post.getId(),
                post.getTitle(),
                post.getBody()
        );
    }
}
