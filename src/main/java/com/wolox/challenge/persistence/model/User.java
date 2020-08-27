package com.wolox.challenge.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Basic
    @Column(name = "username", length = 45, nullable = false)
    private String username;

    @Basic
    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @Basic
    @Column(name = "phone", length = 45, nullable = false)
    private String phone;

    @Basic
    @Column(name = "website", length = 120, nullable = false)
    private String website;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "user")
    private Set<Album> albums;

    @ManyToMany
    private Set<Album> albumsAccess;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;


}
