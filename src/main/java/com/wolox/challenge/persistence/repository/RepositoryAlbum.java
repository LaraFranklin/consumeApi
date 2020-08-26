package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAlbum extends JpaRepository<Album, Integer> {
}
