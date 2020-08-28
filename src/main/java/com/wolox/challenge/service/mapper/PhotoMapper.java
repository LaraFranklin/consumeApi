package com.wolox.challenge.service.mapper;

import com.wolox.challenge.persistence.model.Photo;
import com.wolox.challenge.service.AlbumService;
import com.wolox.challenge.service.dto.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PhotoMapper {

    @Autowired
    AlbumService albumService;

    public Photo toPhoto(PhotoDto photoDto) {
        return new Photo(
                photoDto.getId(),
                photoDto.getTitle(),
                photoDto.getUrl(),
                photoDto.getThumbnailUrl(),
                albumService.getById(photoDto.getAlbumId())
        );
    }

    public PhotoDto toPhotoDto(Photo photo) {
        return new PhotoDto(
                photo.getAlbum().getId(),
                photo.getId(),
                photo.getTitle(),
                photo.getUrl(),
                photo.getThumbnailUrl()
        );
    }

    public Set<PhotoDto> toListPhotoDto(List<Photo> photos) {
        return photos.stream()
                .filter(Objects::nonNull)
                .map(this::toPhotoDto)
                .collect(Collectors.toSet());
    }
}
