package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    private int id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;


}
