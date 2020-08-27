package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RepositoryAlbum extends JpaRepository<Album, Integer> {

    @Query(value = "select access_albums_id from album_access_albums al where al.album_id = ?1", nativeQuery = true)
    Set<Integer> findByAccessAlbums(int idAlbum);
}
