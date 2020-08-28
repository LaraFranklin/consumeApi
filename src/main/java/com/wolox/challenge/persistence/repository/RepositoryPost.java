package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPost extends JpaRepository<Post, Integer> {
}
