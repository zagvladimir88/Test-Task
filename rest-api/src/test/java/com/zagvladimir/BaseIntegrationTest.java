package com.zagvladimir;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;


public abstract class BaseIntegrationTest {

  private static final MySQLContainer<?> container =
      new MySQLContainer<>("mysql:8.0.24");

  @BeforeAll
  static void ruContainer() {
    container.start();
  }

  @DynamicPropertySource
  static void postgresProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", container::getJdbcUrl);
  }
}
