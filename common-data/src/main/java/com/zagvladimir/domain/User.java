package com.zagvladimir.domain;


import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "role")
@ToString(exclude = "role")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;

    private String firstname;

    private String patronymic;

    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
