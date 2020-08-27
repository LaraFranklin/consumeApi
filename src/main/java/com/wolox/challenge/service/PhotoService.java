package com.wolox.challenge.service;

import com.wolox.challenge.service.dto.PhotoDto;

import java.util.List;

public interface PhotoService {

    PhotoDto add(PhotoDto photoDto);
    List<PhotoDto> getByIdUser(int idUser);

}
