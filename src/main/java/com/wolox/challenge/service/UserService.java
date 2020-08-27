package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> add(UserDto userDto);
}
