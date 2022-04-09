package com.wolox.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.challenge.persistence.model.Album;
import com.wolox.challenge.persistence.repository.RepositoryAlbum;

@Service
public class ServiceAlbum {
	
	
	@Autowired
	RepositoryAlbum album;
	
	
	
	public List<Album> obteneralbumessinacceso(int id) {
		List<Album> datos = album.albunes(id);
		return datos;
	}

}
