package com.paymatrix.todo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.service.ToDoService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class ToDoControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ToDoService toDoService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldSaveTheToDo() throws Exception {
        ToDo javaToDo = new ToDo("Read Java", new Date(), false);
        when(toDoService.save(any(ToDo.class))).thenReturn(javaToDo);
        String javaToDoJSON = objectMapper.writeValueAsString(javaToDo);

        ResultActions result = mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(javaToDoJSON)
        );

        result.andExpect(jsonPath("$.text").value("Read Java"))
                .andExpect(jsonPath("$.completed").value(false))
                .andExpect(status().isCreated());

        verify(toDoService, times(1)).save(any(ToDo.class));

    }

}