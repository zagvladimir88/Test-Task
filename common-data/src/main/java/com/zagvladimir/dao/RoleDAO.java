package com.zagvladimir.dao;

import com.zagvladimir.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDAO extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(String roleName);
}
