package com.zagvladimir.dto;

import com.zagvladimir.domain.SystemRoles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserCreateRequest {

    @Size(max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String surname;

    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String firstname;

    @Size(max = 40)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String patronymic;

    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    private SystemRoles role;
}
