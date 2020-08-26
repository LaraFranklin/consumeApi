package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAddress extends JpaRepository<Address, Integer> {
}
