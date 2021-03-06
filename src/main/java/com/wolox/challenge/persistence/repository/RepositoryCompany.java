package com.wolox.challenge.persistence.repository;

import com.wolox.challenge.persistence.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryCompany extends JpaRepository<Company, Integer> {

    Optional<Company> findByName(String name);
}
