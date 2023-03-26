package com.zagvladimir.controller;

import com.zagvladimir.domain.User;
import com.zagvladimir.dto.UserCreateRequest;
import com.zagvladimir.dto.UserResponse;
import com.zagvladimir.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAllUsers(Pageable pageable) {
        Page<UserResponse> users = userService.findAll(pageable);
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> addUser(@Valid @RequestBody UserCreateRequest createRequest) {
        User createdUser = userService.create(createRequest);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
