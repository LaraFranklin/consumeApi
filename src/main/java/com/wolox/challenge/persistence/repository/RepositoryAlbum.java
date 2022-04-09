package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RepositoryAlbum extends JpaRepository<Album, Integer> {

    @Query(value = "select access_albums_id from album_access_albums al where al.album_id = :idAlbum", nativeQuery = true)
    Set<Integer> findByAccessAlbums(int idAlbum);

    @Query(value = "select a from album_access_albums al left join album a on a.id = al.album_id where al.album_id = :idAlbum", nativeQuery = true)
    Album findByAccessAlbumsUser(int idAlbum);
    
    @Query(value = "SELECT * FROM  album a  inner join album_access_albums t ON t.album_id = a.id where a.user_id not in (:idusuario)", nativeQuery = true)
	List<Album> albunes(int idusuario);
}
