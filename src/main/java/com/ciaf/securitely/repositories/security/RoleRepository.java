package com.ciaf.securitely.repositories.security;

import com.ciaf.securitely.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
