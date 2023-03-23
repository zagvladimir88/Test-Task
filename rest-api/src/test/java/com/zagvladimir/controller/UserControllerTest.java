package com.zagvladimir.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zagvladimir.BaseIntegrationTest;
import com.zagvladimir.annotations.IT;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Paths;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IT
class UserControllerTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void testFindAllUsers() {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/users/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['pageable']['paged']").value("true"))
                .andExpect(jsonPath("$.content[0].fullname").value("Ivanov Ivan Ivanovich"));
    }

    @Test
    @SneakyThrows
    void testAddUser() {
        Map<?, ?> map =
                objectMapper.readValue(
                        Paths.get("src/test/resources/json_for_test/userCreate.json").toFile(), Map.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(map))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstname").value("Test"))
                .andExpect(jsonPath("$.role.name").value("ROLE_ADMINISTRATOR"));

    }

    @Test
    @SneakyThrows
    void testFailAddUserBecauseCyrillicIsUsedAndIncorrectEmail() {
        Map<?, ?> map =
                objectMapper.readValue(
                        Paths.get("src/test/resources/json_for_test/userFailCreate.json").toFile(), Map.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(map))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error.surname").value("must match \"^[a-zA-Z]*$\""))
                .andExpect(jsonPath("$.error.email").value("must be a well-formed email address"));
    }
}