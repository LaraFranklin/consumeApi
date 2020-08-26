package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.service.dto.AddressDto;
import com.wolox.challenge.service.dto.CompanyDto;
import com.wolox.challenge.service.dto.GeoDto;
import com.wolox.challenge.service.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public static UserDto toUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getWebsite(),
                new AddressDto(
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
                        user.getCompany().getName(),
                        user.getCompany().getCatchPhrase(),
                        user.getCompany().getBs()
                )
        );
    }

//    public static User toUser(UserDto userDto){
//        return new User(
//                userDto.getId(),
//                userDto.getName(),
//                userDto.getUsername(),
//                userDto.getEmail(),
//                userDto.getPhone(),
//                userDto.getWebsite(),
//                new Address(
//                        null,
//                        userDto.getAddress().getStreet(),
//                        userDto.getAddress().getSuite(),
//                        userDto.getAddress().getCity(),
//                        userDto.getAddress().getZipcode(),
//                        userDto.getAddress().getGeo.getLat(),
//                        userDto.getAddress().getGeo.getLng()
//                ),
//                null
//
//        );
//    }


}
