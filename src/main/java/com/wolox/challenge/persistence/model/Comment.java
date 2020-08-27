package com.wolox.challenge.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Basic
    @Column(name = "name", length = 120, nullable = false)
    public String name;

    @Basic
    @Column(name = "email", length = 90, nullable = false)
    public String email;

    @Basic
    @Column(name = "body", length = 300, nullable = false)
    public String body;

    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    public Post post;
}
