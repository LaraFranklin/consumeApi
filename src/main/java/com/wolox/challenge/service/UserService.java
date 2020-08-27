package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserDto add(UserDto userDto);
    Set<UserDto> getAll();
    UserDto getById(int id);
    Set<Integer> getByAccessAlbum(int idAlbum);
}
