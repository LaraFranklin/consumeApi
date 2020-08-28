package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.Post;
import com.wolox.challenge.persistence.repository.RepositoryPost;
import com.wolox.challenge.service.PostService;
import com.wolox.challenge.service.dto.PostDto;
import com.wolox.challenge.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    RepositoryPost repositoryPost;

    @Autowired
    PostMapper postMapper;

    @Override
    public PostDto add(PostDto postDto) {
        return postMapper.toPostDto(repositoryPost.save(postMapper.toPost(postDto)));
    }

    @Override
    public Post getById(int id) {
        return repositoryPost.findById(id).get();
    }
}
