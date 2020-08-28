package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserList implements Serializable {

    private List<UserDto> users;

    public UserList() {
        this.users = new ArrayList<>();
    }
}
