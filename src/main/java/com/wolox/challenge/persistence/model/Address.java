package com.wolox.challenge.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "street", length = 60)
    private String street;

    @Basic
    @Column(name = "suite", length = 60)
    private String suite;

    @Basic
    @Column(name = "city", length = 60)
    private String city;

    @Basic
    @Column(name = "zipcode", length = 25)
    private String zipcode;

    @Basic
    @Column(name = "lat", length = 45, nullable = false)
    private String lat;

    @Basic
    @Column(name = "lng", length = 45, nullable = false)
    private String lng;


}
