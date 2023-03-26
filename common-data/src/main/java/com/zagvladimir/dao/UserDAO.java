package com.zagvladimir.dao;

import com.zagvladimir.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User, Long> {

}
