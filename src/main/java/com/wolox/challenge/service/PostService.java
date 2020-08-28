package com.wolox.challenge.service;

import com.wolox.challenge.persistence.model.Post;
import com.wolox.challenge.service.dto.PostDto;

public interface PostService {

    PostDto add(PostDto postDto);

    Post getById(int id);


}
