package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryComment extends JpaRepository<Comment, Integer> {
}
