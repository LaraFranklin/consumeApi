package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPhoto extends JpaRepository<Photo, Integer> {
}
