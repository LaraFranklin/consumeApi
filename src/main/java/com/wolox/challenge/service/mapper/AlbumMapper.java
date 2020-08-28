package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.persistence.repository.RepositoryUser;
import com.wolox.challenge.service.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlbumMapper {

    @Autowired
    RepositoryUser repositoryUser;

    public Album toAlbum(AlbumDto albumDto) {
        return new Album(
                albumDto.getId(),
                albumDto.getTitle(),
                null,
                repositoryUser.findById(albumDto.getUserId()).get(),
                null
        );
    }

    public AlbumDto toAlbumDto(Album album) {
        return new AlbumDto(
                album.getUser().getId(),
                album.getId(),
                album.getTitle()
        );
    }

    public Set<AlbumDto> toListoAlbumDto(List<Album> albums) {
        return albums.stream()
                .filter(Objects::nonNull)
                .map(this::toAlbumDto)
                .collect(Collectors.toSet());
    }


}
