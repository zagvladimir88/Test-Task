package com.zagvladimir.service;

import com.zagvladimir.domain.User;
import com.zagvladimir.dto.UserCreateRequest;
import com.zagvladimir.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {

    User create(UserCreateRequest request);

    Page<UserResponse> findAll(Pageable pageable);
}
