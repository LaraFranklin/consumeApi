package com.wolox.challenge.controller;

import com.wolox.challenge.service.ConsumeApiService;
import com.wolox.challenge.service.UserService;
import com.wolox.challenge.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    ConsumeApiService consumeApiService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> consul() {
        try {
            consumeApiService.getUser();
            consumeApiService.getAlbum();
            consumeApiService.getPhoto();
            consumeApiService.getPost();
            consumeApiService.getComment();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error consume API", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/getAll")
    public Set<UserDto> findAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto finById(
            @PathVariable Integer id
    ) {
        return userService.getById(id);
    }

    @GetMapping("/getByAccessAlbumId/{id}")
    public Set<Integer> getByAccessAlbum(
            @PathVariable Integer id
    ) {
        return userService.getByAccessAlbum(id);
    }

    @GetMapping("/getByAccessAlbumUser/{id}")
    public Set<UserDto> getByAccessAlbumUser(
            @PathVariable Integer id
    ) {
        return userService.getByAccessAlbumUser(id);
    }


}
