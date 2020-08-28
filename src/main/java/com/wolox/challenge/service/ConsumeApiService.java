package com.wolox.challenge.service;

import org.springframework.http.ResponseEntity;

public interface ConsumeApiService {

    ResponseEntity<?> getUser();

    ResponseEntity<?> getAlbum();

    ResponseEntity<?> getPhoto();

    ResponseEntity<?> getPost();

    ResponseEntity<?> getComment();


}
