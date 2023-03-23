--liquibase formatted sql

--changeset zavladimir:1
INSERT INTO roles (name)
VALUES ('ROLE_ADMINISTRATOR'),
       ('ROLE_SALE_USER'),
       ('ROLE_CUSTOMER_USER'),
       ('ROLE_SECURE_API_USER');

--changeset zavladimir:2
INSERT INTO users (surname, firstname, patronymic, email, role_id)
VALUES ('Simpson', 'Homer', 'Jay', 'hsimpson@springfieldnuclear.com', 1),
       ('Simpson', 'Marge', 'Jacqueline', 'msimpson@springfield.com', 2),
       ('Simpson', 'Bart', 'Jojo', 'bsimpson@springfield.com', 2),
       ('Simpson', 'Lisa', 'Marie', 'lsimpson@springfield.com', 3),
       ('Simpson', 'Maggie', 'Marie', 'msimpsonjr@springfield.com', 4),
       ('Marsh', 'Stanley', 'Randall ', 'smarsh@southpark.com', 3),
       ('Broflovski', 'Kyle', 'Gerald ', 'kbroflovski@southpark.com', 2),
       ('Cartman', 'Eric', 'Jack', 'ecartman@southpark.com', 1),
       ('McCormick', 'Kenneth', 'Gen', 'kmccormick@southpark.com', 4),
       ('Stotch', 'Leopold', 'Butters', 'lstotch@southpark.com', 4);








