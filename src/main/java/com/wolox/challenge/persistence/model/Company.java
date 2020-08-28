package com.wolox.challenge.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Basic
    @Column(name = "catch_phrase", length = 100, nullable = false)
    private String catchPhrase;

    @Basic
    @Column(name = "bs", length = 60)
    private String bs;

    @OneToMany(mappedBy = "company")
    private Set<User> users;

}
