package com.wolox.challenge.service.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;


}
