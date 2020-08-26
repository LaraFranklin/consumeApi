package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto implements Serializable {

    private String name;
    private String catchPhrase;
    private String bs;
}
