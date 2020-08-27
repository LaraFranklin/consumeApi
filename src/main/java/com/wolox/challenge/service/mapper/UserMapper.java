package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.Address;
import com.wolox.challenge.persistence.model.Company;
import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.service.dto.AddressDto;
import com.wolox.challenge.service.dto.CompanyDto;
import com.wolox.challenge.service.dto.GeoDto;
import com.wolox.challenge.service.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public UserDto toUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getWebsite(),
                new AddressDto(
                        user.getAddress().getId(),
                        user.getAddress().getStreet(),
                        user.getAddress().getSuite(),
                        user.getAddress().getCity(),
                        user.getAddress().getZipcode(),
                        new GeoDto(
                                user.getAddress().getLat(),
                                user.getAddress().getLng()
                        )
                ),
                new CompanyDto(
                        user.getCompany().getId(),
                        user.getCompany().getName(),
                        user.getCompany().getCatchPhrase(),
                        user.getCompany().getBs()
                )
        );
    }

    public Set<UserDto> toListUserDto(List<User> users){
            return users.stream()
                    .filter(Objects::nonNull)
                    .map(this::toUserDto)
                    .collect(Collectors.toSet());
    }

    public static User toUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getWebsite(),
                new Address(
                        userDto.getAddress().getId(),
                        userDto.getAddress().getStreet(),
                        userDto.getAddress().getSuite(),
                        userDto.getAddress().getCity(),
                        userDto.getAddress().getZipcode(),
                        userDto.getAddress().getGeo().getLat(),
                        userDto.getAddress().getGeo().getLng()
                ),
                new Company(
                    userDto.getCompany().getId(),
                        userDto.getCompany().getName(),
                        userDto.getCompany().getCatchPhrase(),
                        userDto.getCompany().getBs(),
                        null
                ),
                null,
                null,
                null


        );
    }


}
