package com.ciaf.securitely.repositories.security;

import com.ciaf.securitely.entities.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
