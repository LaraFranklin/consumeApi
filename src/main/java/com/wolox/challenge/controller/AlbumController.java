package com.wolox.challenge.controller;

import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.service.AlbumService;
import com.wolox.challenge.service.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping("/{idUser}/{idAlbum}")
    public AlbumDto addAccess(
            @PathVariable Integer idUser,
            @PathVariable Integer idAlbum
    ) {
        return albumService.addAccessUser(idAlbum, idUser).get();
    }

    @GetMapping("/{id}")
    public Album getOne(
            @PathVariable Integer id
    ) {
        return albumService.getById(id);
    }
}
