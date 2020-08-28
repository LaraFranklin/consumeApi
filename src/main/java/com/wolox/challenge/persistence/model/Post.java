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
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Basic
    @Column(name = "body", length = 300)
    private String body;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "id")
    private User user;
}
