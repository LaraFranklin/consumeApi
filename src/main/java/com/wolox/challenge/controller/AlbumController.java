package com.wolox.challenge.controller;

import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.service.AlbumService;
import com.wolox.challenge.service.ServiceAlbum;
import com.wolox.challenge.service.dto.AlbumDto;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;
    
    @Autowired
	ServiceAlbum alb;

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
    
    @GetMapping(value = "/acceso")
	public ResponseEntity<List<Album>> getsinacceso(@RequestParam("id") Integer id) throws SQLException {
		return new ResponseEntity<List<Album>>(alb.obteneralbumessinacceso(id), HttpStatus.OK);
	}
}
