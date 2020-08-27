package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.persistence.repository.RepositoryAlbum;
import com.wolox.challenge.persistence.repository.RepositoryUser;
import com.wolox.challenge.service.UserService;
import com.wolox.challenge.service.dto.UserDto;
import com.wolox.challenge.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryAlbum repositoryAlbum;

    public UserServiceImple() {
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        user = repositoryUser.save(user);
        return userMapper.toUserDto(user);
    }

    @Override
    public Set<UserDto> getAll() {
        return userMapper.toListUserDto(repositoryUser.findAll());
    }

    @Override
    public UserDto getById(int id) {
        return repositoryUser.findById(id).map(userMapper::toUserDto).get();
    }

    @Override
    public Set<Integer> getByAccessAlbum(int idAlbum) {
        return repositoryAlbum.findByAccessAlbums(idAlbum);
    }
}
