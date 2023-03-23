package com.zagvladimir.service;

import com.zagvladimir.dao.RoleDAO;
import com.zagvladimir.dao.UserDAO;
import com.zagvladimir.domain.Role;
import com.zagvladimir.domain.SystemRoles;
import com.zagvladimir.domain.User;
import com.zagvladimir.dto.UserCreateRequest;
import com.zagvladimir.dto.UserResponse;
import com.zagvladimir.mappers.UserMapper;
import com.zagvladimir.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDAO userDAO;
    @Mock
    private RoleDAO roleDAO;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateWithValidRequest() {
        UserCreateRequest request = new UserCreateRequest();
        request.setFirstname("TestSurName");
        request.setSurname("TestFirstName");
        request.setPatronymic("TestPatronymic");
        request.setEmail("test@example.com");
        request.setRole(SystemRoles.ROLE_ADMINISTRATOR);

        User mappedUser = new User();
        mappedUser.setSurname("TestSurName");
        mappedUser.setFirstname("TestFirstName");
        mappedUser.setPatronymic("TestPatronymic");
        mappedUser.setEmail("test@example.com");
        mappedUser.setRole(new Role());

        when(userMapper.convertCreateRequest(request)).thenReturn(mappedUser);
        when(roleDAO.findRoleByName(request.getRole().toString())).thenReturn(Optional.of(new Role()));
        when(userDAO.save(any())).thenReturn(mappedUser);

        User createdUser = userService.create(request);
        assertEquals("TestFirstName", createdUser.getFirstname());
        assertEquals("test@example.com", createdUser.getEmail());
        Assertions.assertNotNull(createdUser.getRole());
    }

    @Test
    void testFindAllReturnsListOfUsers() {
        List<User> userList = Arrays.asList(
                new User(1L, "Ivanov", "Ivan", "Ivanovich", "vanya@example.com", new Role()),
                new User(2L, "Petrov", "Petr", "Petrovich", "vasya@example.com", new Role())
        );
        Page<User> userPage = new PageImpl<>(userList);

        when(userDAO.findAll(any(Pageable.class))).thenReturn(userPage);
        when(userMapper.toUserResponse(any(User.class))).thenAnswer(
                invocation -> {
                    User user = invocation.getArgument(0);
                    return new UserResponse(user.getSurname() + " " + user.getFirstname() + " " + user.getPatronymic(), user.getEmail(), user.getRole().getName());
                });

        Pageable pageable = PageRequest.of(0, 10);
        Page<UserResponse> result = userService.findAll(pageable);

        assertEquals(2, result.getContent().size());
        assertEquals("vanya@example.com", result.getContent().get(0).getEmail());
        assertEquals("Petrov Petr Petrovich", result.getContent().get(1).getFullname());
        verify(userDAO, times(1)).findAll(any(Pageable.class));
        verify(userMapper, times(2)).toUserResponse(any(User.class));
    }
}
