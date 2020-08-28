package com.wolox.challenge.service.imple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolox.challenge.service.*;
import com.wolox.challenge.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConsumeApiServiceImple implements ConsumeApiService {

    private static final String uri = "https://jsonplaceholder.typicode.com/";

    @Autowired
    UserService userService;

    @Autowired
    AlbumService albumService;

    @Autowired
    PhotoService photoService;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    Gson gson;


    private String getRestApi(String resource) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri + resource, String.class);
    }

    @Override
    public ResponseEntity<?> getUser() {
        String re = getRestApi("users");
        List<UserDto> users = gson.fromJson(
                getRestApi("users"),
                new TypeToken<List<UserDto>>() {
                }.getType());
        for (UserDto userDto : users) {
            userService.add(userDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAlbum() {
        List<AlbumDto> albums = gson.fromJson(
                getRestApi("albums"),
                new TypeToken<List<AlbumDto>>() {
                }.getType());
        for (AlbumDto albumDto : albums) {
            albumService.add(albumDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPhoto() {
        List<PhotoDto> photos = gson.fromJson(
                getRestApi("photos"),
                new TypeToken<List<PhotoDto>>() {
                }.getType());
        for (PhotoDto photoDto : photos) {
            photoService.add(photoDto);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getPost() {
        List<PostDto> posts = gson.fromJson(
                getRestApi("posts"),
                new TypeToken<List<PostDto>>() {
                }.getType());
        for (PostDto postDto : posts) {
            postService.add(postDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getComment() {
        List<CommentDto> comments = gson.fromJson(
                getRestApi("comments"),
                new TypeToken<List<CommentDto>>() {
                }.getType());
        for (CommentDto commentDto : comments) {
            commentService.add(commentDto);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
