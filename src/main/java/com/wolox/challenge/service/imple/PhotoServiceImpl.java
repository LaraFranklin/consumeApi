package com.wolox.challenge.service.imple;

import com.wolox.challenge.persistence.model.Photo;
import com.wolox.challenge.persistence.repository.RepositoryPhoto;
import com.wolox.challenge.service.PhotoService;
import com.wolox.challenge.service.dto.PhotoDto;
import com.wolox.challenge.service.mapper.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    RepositoryPhoto repositoryPhoto;

    @Autowired
    PhotoMapper photoMapper;

    @Override
    public PhotoDto add(PhotoDto photoDto) {
        Photo photo = photoMapper.toPhoto(photoDto);
        return photoMapper.toPhotoDto(repositoryPhoto.save(photo));
    }

    @Override
    public List<PhotoDto> getByIdUser(int idUser) {
        return null;
    }

    @Override
    public Set<PhotoDto> getAll() {
        return photoMapper.toListPhotoDto(repositoryPhoto.findAll());
    }

    @Override
    public PhotoDto getById(int id) {
        return photoMapper.toPhotoDto(repositoryPhoto.findById(id).get());
    }
}
