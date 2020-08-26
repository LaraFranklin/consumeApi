package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto implements Serializable {

    private int userId;
    private int id;
    private String title;

}
