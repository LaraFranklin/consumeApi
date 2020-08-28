package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.PhotoDto;

import java.util.List;
import java.util.Set;

public interface PhotoService {

    PhotoDto add(PhotoDto photoDto);

    List<PhotoDto> getByIdUser(int idUser);

    Set<PhotoDto> getAll();

    PhotoDto getById(int id);

}
