package com.wolox.challenge.service;

import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.service.dto.UserDto;

import java.util.Set;

public interface UserService {

    UserDto add(UserDto userDto);

    Set<UserDto> getAll();

    UserDto getById(int id);

    User getUserById(int id);

    Set<Integer> getByAccessAlbum(int idAlbum);

    Set<UserDto> getByAccessAlbumUser(int idAlbum);
}
