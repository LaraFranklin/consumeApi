package com.wolox.challenge.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Basic
    @Column(name = "url", length = 245, nullable = false)
    private String url;

    @Basic
    @Column(name = "thumbnail_url", length = 200, nullable = false)
    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

//    @OneToMany(mappedBy = "albums")
//    private Set<Album> albums;
}
