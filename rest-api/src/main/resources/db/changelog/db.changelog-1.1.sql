--liquibase formatted sql

--changeset zavladimir:1
INSERT INTO roles (name)
VALUES ('ROLE_ADMINISTRATOR'),
       ('ROLE_SALE_USER'),
       ('ROLE_CUSTOMER_USER'),
       ('ROLE_SECURE_API_USER');

--changeset zavladimir:2
INSERT INTO users (surname, firstname, patronymic, email, role_id)
VALUES ('Ivanov', 'Ivan', 'Ivanovich', 'ivanov@mail.ru', 1),
       ('Petrov', 'Petr', 'Petrovich', 'petrov@mail.ru', 2),
       ('Sidorov', 'Sidor', 'Sidorovich', 'sidorov@mail.ru', 2),
       ('Kuznetsov', 'Alexey', 'Vladimirovich', 'kuznetsov@mail.ru', 3),
       ('Smirnova', 'Elena', 'Alexandrovna', 'smirnova@mail.ru', 4),
       ('Kozlova', 'Olga', 'Vladimirovna', 'kozlova@mail.ru', 3),
       ('Mikhailova', 'Maria', 'Andreevna', 'mikhailova@mail.ru', 2),
       ('Nikolaeva', 'Natalya', 'Vladimirovna', 'nikolaeva@mail.ru', 1),
       ('Kuzmina', 'Tatiana', 'Alexandrovna', 'kuzmina@mail.ru', 4),
       ('Lebedeva', 'Ekaterina', 'Vladimirovna', 'lebedeva@mail.ru', 4);


