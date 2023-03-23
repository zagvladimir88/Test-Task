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
* `/api/users` - POST endpoint для добавления пользователя с полями surname, firstname, patronymic, email и role.

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


# Running the Application
To run the application, follow these steps:

1. Make sure you have [Maven](https://maven.apache.org/) and [Docker Compose](https://docs.docker.com/compose/) installed on your system.
2. Open a terminal and navigate to the root directory of the project.
3. Run the following command to build the application using Maven:

```
mvn clean install
```
4. Once the build is complete, run the following command to start the application using Docker Compose:

```
docker-compose up
```
This will start all the required services, including the MySQL database and the application itself.
You can now access the application by opening a web browser and navigating to http://localhost:8080.

---
Чтобы запустить приложение, выполните следующие действия:

1. Убедитесь, что в вашей системе установлены [Maven](https://maven.apache.org/) и [Docker Compose](https://docs.docker.com/compose/).
2. Откройте терминал и перейдите в корневой каталог проекта.
3. Запустите следующую команду, чтобы собрать приложение с помощью Maven:

```
mvn clean install
```
4. После завершения сборки выполните следующую команду, чтобы запустить приложение с помощью Docker Compose:

```
docker-compose up
```
Это запустит все необходимые службы, включая базу данных MySQL и само приложение.
Теперь вы можете получить доступ к приложению, открыв веб-браузер и перейдя по адресу http://localhost:8080.

# Testing
Unit and integration tests have been included using JUnit and testcontainers to raise the test base in Docker. `Docker must be running` to pass integration tests

---
Модульные и интеграционные тесты сделаны с использованием JUnit и Testcontainer's для поднятия тестовой базы в Docker. Для прохождения интеграционных тестов `обязательно должен быть запущен Docker`
# Additionally
This project is a test task for IT-BOOTCAMP Backend Java Developer.

---
Этот проект является тестовым заданием для IT-BOOTCAMP Backend Java Developer.
