--liquibase formatted sql

--changeset zavladimir:1
create table if not exists roles
(
    id   bigint auto_increment
    primary key,
    name varchar(20) default 'customer_user' null,
    constraint roles_id_uindex
    unique (id)
    );
--rollback DROP TABLE roles

--changeset zavladimir:2
create table if not exists users
(
    id         bigint auto_increment
        primary key,
    surname    varchar(40) null,
    firstname  varchar(20) null,
    patronymic varchar(40) null,
    email      varchar(50) null,
    role_id    bigint      null,
    constraint users_id_uindex
        unique (id),
    constraint users_roles_id_fk
        foreign key (role_id) references roles (id)
);
--rollback DROP TABLE users


