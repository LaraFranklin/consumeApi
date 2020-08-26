package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoDto implements Serializable {

    @NotEmpty
    @NotNull
    private String lat;

    @NotEmpty
    @NotNull
    private String lng;

}
