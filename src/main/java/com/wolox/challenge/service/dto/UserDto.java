package com.wolox.challenge.service.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressDto address;
    private CompanyDto company;

}
