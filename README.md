Test-Task

# Project Description

This is a project with a three-level development architecture.
It is a backend Java application built using Java 11, Spring Boot 2, and MySQL 8.
The application uses REST architectural style and JSON format for the API.
It includes endpoints for adding a user and getting all users, with features such as error handling,
English character validation, email validity check, sorting, and pagination.

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

Example json for a request to create a user  :
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

# Testing
Unit and integration tests have been included using JUnit and testcontainers to raise the test base in Docker. `Docker must be running` to pass integration tests

# Additionally
This project is a test task.
