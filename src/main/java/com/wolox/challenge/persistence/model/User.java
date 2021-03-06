package com.wolox.challenge.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<Album> albums;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<Post> posts;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable
//    private Set<Album> userAccess;
}
