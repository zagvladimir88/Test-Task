package com.zagvladimir.service;

import com.zagvladimir.dao.RoleDAO;
import com.zagvladimir.dao.UserDAO;
import com.zagvladimir.domain.Role;
import com.zagvladimir.domain.User;
import com.zagvladimir.dto.UserCreateRequest;
import com.zagvladimir.dto.UserResponse;
import com.zagvladimir.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;


@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final UserMapper userMapper;

    @Override
    public User create(UserCreateRequest request) {
        log.info("Create new user from request: {}", request.toString());

        User createUser = userMapper.convertCreateRequest(request);
        Optional<Role> userRole = roleDAO.findRoleByName(request.getRole().toString());

        if (userRole.isPresent()) {
            createUser.setRole(userRole.get());
            log.info("Role sets successful {}", userRole.get().getName());
        } else {
            log.error("Role  {} not found", request.getRole().toString());
            throw new EntityNotFoundException("Role " + request.getRole().toString() + " not found");
        }

        User createdUser = userDAO.save(createUser);
        log.info("User create successful {}", createdUser);
        return createdUser;
    }

    @Override
    public Page<UserResponse> findAll(Pageable pageable) {
        log.info("Request all users");
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("email").ascending());
        return userDAO.findAll(sortedPageable).map(userMapper::toUserResponse);
    }
}
