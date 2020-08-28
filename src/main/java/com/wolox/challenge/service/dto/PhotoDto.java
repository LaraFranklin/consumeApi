package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto implements Serializable {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
