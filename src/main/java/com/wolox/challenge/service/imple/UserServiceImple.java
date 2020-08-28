package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.Address;
import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.persistence.model.Company;
import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.persistence.repository.RepositoryAddress;
import com.wolox.challenge.persistence.repository.RepositoryAlbum;
import com.wolox.challenge.persistence.repository.RepositoryUser;
import com.wolox.challenge.service.CompanyService;
import com.wolox.challenge.service.UserService;
import com.wolox.challenge.service.dto.UserDto;
import com.wolox.challenge.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RepositoryUser repositoryUser;

    @Autowired
    RepositoryAlbum repositoryAlbum;

    @Autowired
    RepositoryAddress repositoryAddress;

    @Autowired
    CompanyService companyService;

    public UserServiceImple() {
    }

    @Override
    @Transactional
    public UserDto add(UserDto userDto) {

        User user2 = new User();
        Company company = companyService.add(userDto.getCompany());

        Address address = new Address();
        address.setId(userDto.getAddress().getId());
        address.setStreet(userDto.getAddress().getStreet());
        address.setSuite(userDto.getAddress().getSuite());
        address.setCity(userDto.getAddress().getCity());
        address.setZipcode(userDto.getAddress().getZipcode());
        address.setLat(userDto.getAddress().getGeo().getLat());
        address.setLng(userDto.getAddress().getGeo().getLng());

        address = repositoryAddress.saveAndFlush(address);

        user2.setId(userDto.getId());
        user2.setName(userDto.getName());
        user2.setUsername(userDto.getUsername());
        user2.setEmail(userDto.getEmail());
        user2.setPhone(userDto.getPhone());
        user2.setWebsite(userDto.getWebsite());
        user2.setCompany(company);
        user2.setAddress(address);

        return userMapper.toUserDto(repositoryUser.save(user2));
    }

    @Override
    public Set<UserDto> getAll() {
        return userMapper.toListUserDto((Set<User>) repositoryUser.findAll());
    }

    @Override
    public UserDto getById(int id) {
        return repositoryUser.findById(id).map(userMapper::toUserDto).get();
    }

    @Override
    public User getUserById(int id) {
        return repositoryUser.findById(id).get();
    }

    @Override
    public Set<Integer> getByAccessAlbum(int idAlbum) {
        return repositoryAlbum.findByAccessAlbums(idAlbum);
    }

    @Override
    public Set<UserDto> getByAccessAlbumUser(int idAlbum) {
        Album a = repositoryAlbum.findById(idAlbum).get();
//        Set<User> as = repositoryAlbum.findByAccessAlbumsUser(idAlbum).getAccessAlbums();
        return userMapper.toListUserDto(repositoryAlbum.findById(idAlbum).get().getAccessAlbums());
    }
}
