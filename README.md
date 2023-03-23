# IT-Bootcamp-Java-Developer-Test-Task

# Project Description

This is a multi-module Maven project with a three-level, three-module development architecture.
It is a backend Java application built using Java 11, Spring Boot 2, and MySQL 8.
The application uses REST architectural style and JSON format for the API.
It includes endpoints for adding a user and getting all users, with features such as error handling,
English character validation, email validity check, sorting, and pagination.

---
Это многомодульный Maven проект. 
Это серверное Java-приложение, созданное с использованием Java 11, Spring Boot 2 и MySQL 8.
Приложение использует архитектурный стиль REST и формат JSON для API. 
Оно включает в себя конечные точки для добавления пользователя и получения всех пользователей с такими функциями, как обработка ошибок,
проверка ввода(только латинские символы), валидация email адреса, сортировка и разбиение на страницы.

# Technologies
* Java 11
* Spring Boot 2
* MySQL 8
* Spring AOP
* Log4j2
* Liquibase
* JUnit
* Mockito
* Testcontainers

# Endpoints
* `/api/users` - POST endpoint for adding a user with fields for Surname, Firstname, Patronymic, Email, and Role.

---
* `/api/users` - POST endpoint для добавления пользователя с полями для Фамилия, Имя, Отчество, Электронная почта и Роль.

Example json for a request to create a user / Пример json для запроса на создание пользователя :
``` json
{
  "surname": "Sobchak",
  "firstname": "Walter",
  "patronymic": "Lebowski",
  "email": "big.lebowski@gmail.com",
  "role": "ROLE_ADMINISTRATOR"
}
```

* `/api/users` - GET endpoint to get all users with fields for Full Name, Email, and Role. Use `?page=0&size=10` for pagination. Entries are sorted alphabetically by email and paginated to show 10 records.
---
* `/api/users` — конечная точка GET, чтобы получить всех пользователей с полями fullname, email и role. Для пагинации используйте `?page=0&size=10`. 
Записи сортируются в алфавитном порядке по электронной почте и разбиваются на страницы для отображения 10 записей. 

response example / пример ответа:
```
{
    "content": [
        {
            "fullname": "Simpson Bart Jojo",
            "email": "bsimpson@springfield.com",
            "role": "ROLE_SALE_USER"
        },
        {
            "fullname": "Cartman Eric Jack",
            "email": "ecartman@southpark.com",
            "role": "ROLE_ADMINISTRATOR"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 10,
    "number": 0,
    "size": 10,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 10,
    "empty": false
}
```

# Usage
To run the application, clone the project from the GitHub repository and import it into an IDE.
Set up the MySQL. To start the database in Docker, go to the Docker folder and run Docker Compose. The SQL database with all the necessary parameters will be started in Docker. Alternatively, you can Set up the MySQL manualy database and update the application.properties file with the necessary database information.
Run the application as a Spring Boot application, and you should be able to access the endpoints.

---
Чтобы запустить приложение, клонируйте проект из репозитория GitHub и импортируйте его в IDE.
Настройте MySQL. Чтобы запустить базу данных в Docker, перейдите в папку Docker и запустите файл Docker Compose. База данных SQL со всеми необходимыми параметрами будет запущена в Docker. Кроме того, вы можете настроить базу данных MySQL вручную и обновить файл application.yml необходимой информацией о базе данных.
Запустите приложение как приложение Spring Boot, и вы сможете получить доступ к конечным точкам.

# Testing
Unit and integration tests have been included using JUnit and testcontainers to raise the test base in Docker. `Docker must be running` to pass integration tests

---
Модульные и интеграционные тесты сделаны с использованием JUnit и Testcontainer's для поднятия тестовой базы в Docker. Для прохождения интеграционных тестов `обязательно должен быть запущен Docker`
# Additionally
This project is a test task for IT-BOOTCAMP Backend Java Developer.

---
Этот проект является тестовым заданием для IT-BOOTCAMP Backend Java Developer.
