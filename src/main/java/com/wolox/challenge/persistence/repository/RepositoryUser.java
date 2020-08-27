package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<User, Integer> {

//    List<Integer> findById

//    Set<User> findByAlbumsAccess_
}
