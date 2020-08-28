package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.persistence.model.User;
import com.wolox.challenge.persistence.repository.RepositoryAlbum;
import com.wolox.challenge.persistence.repository.RepositoryUser;
import com.wolox.challenge.service.AlbumService;
import com.wolox.challenge.service.dto.AlbumDto;
import com.wolox.challenge.service.mapper.AlbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    RepositoryAlbum repositoryAlbum;

    @Autowired
    AlbumMapper albumMapper;

    @Autowired
    RepositoryUser repositoryUser;


    @Override
    public AlbumDto add(AlbumDto albumDto) {
        Album album = albumMapper.toAlbum(albumDto);
        album = repositoryAlbum.save(album);
        return albumMapper.toAlbumDto(album);
    }

    @Override
    public Set<AlbumDto> getAll() {
        return albumMapper.toListoAlbumDto(repositoryAlbum.findAll());
    }

    @Override
    public Optional<AlbumDto> addAccessUser(int idAlbum, int idUser) {
        return repositoryAlbum.findById(idAlbum).map(album -> {
                    Set<User> users;
                    if (album.getAccessAlbums() == null || album.getAccessAlbums().size() == 0) {
                        users = new HashSet<>();
                    } else {
                        users = album.getAccessAlbums();
                    }
                    users.add(repositoryUser.findById(idUser).get());
                    album.setAccessAlbums(users);
                    album = repositoryAlbum.saveAndFlush(album);
                    return albumMapper.toAlbumDto(album);
                }
        );
    }

    @Override
    public Album getById(int id) {
        return repositoryAlbum.findById(id).get();
    }
}
