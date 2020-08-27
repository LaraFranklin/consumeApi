package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.AlbumDto;

import java.util.Optional;
import java.util.Set;

public interface AlbumService {

    AlbumDto add(AlbumDto albumDto);
    Set<AlbumDto> getAll();
    Optional<AlbumDto> addAccessUser(int idAlbum, int idUser);

}
