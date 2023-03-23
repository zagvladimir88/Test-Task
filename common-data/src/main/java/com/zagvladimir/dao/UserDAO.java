package com.zagvladimir.dao;

import com.zagvladimir.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {

    List<User> findAll(Sort sort);
}
