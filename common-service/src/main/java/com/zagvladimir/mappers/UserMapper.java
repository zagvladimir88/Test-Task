package com.zagvladimir.mappers;


import com.zagvladimir.domain.User;
import com.zagvladimir.dto.UserCreateRequest;
import com.zagvladimir.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {



    @Mapping(source = "surname",target = "surname")
    @Mapping(source = "firstname",target = "firstname")
    @Mapping(source = "patronymic",target = "patronymic")
    @Mapping(source = "email",target = "email")
    User convertCreateRequest(UserCreateRequest userCreateRequest);


    @Mapping(target = "fullname", expression = "java(user.getSurname() + \" \" + user.getFirstname() + \" \" + user.getPatronymic())")
    @Mapping(source = "role.name",target = "role")
    UserResponse toUserResponse(User user);

}
