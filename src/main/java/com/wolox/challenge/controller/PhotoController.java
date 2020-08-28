package com.wolox.challenge.controller;

import com.wolox.challenge.service.PhotoService;
import com.wolox.challenge.service.dto.PhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @PostMapping("/")
    public PhotoDto add(@Valid PhotoDto photoDto) {
        return photoService.add(photoDto);
    }

    @GetMapping("/getAll")
    public Set<PhotoDto> getAll() {
        return photoService.getAll();
    }

    @GetMapping("/{id}")
    public PhotoDto getById(
            @PathVariable Integer id
    ) {
        return photoService.getById(id);
    }

}
