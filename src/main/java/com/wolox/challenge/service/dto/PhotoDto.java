package com.wolox.challenge.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDto {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
