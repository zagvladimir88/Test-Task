package com.zagvladimir.dto;

import com.zagvladimir.domain.SystemRoles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class UserCreateRequest {

    @Size(max = 40,min = 2)
    @Pattern(regexp = "^[a-zA-Z]*$")
    private String surname;

    @Size(max = 20,min = 2)
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
