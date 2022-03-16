package com.paymatrix.todo.service;

import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class ToDoServiceTest {
    ToDoRepository toDoRepository;
    ToDoService toDoService;

    @BeforeEach
    void setUp() {
        toDoRepository = mock(ToDoRepository.class);
        toDoService = new ToDoService(toDoRepository);
    }

    @Test
    void shouldCallRepositorySave() {
        toDoService.save(mock(ToDo.class));

        verify(toDoRepository, times(1)).save(any(ToDo.class));
    }

    @Test
    void shouldFetchAllToDos() {
        toDoService.getToDos();

        verify(toDoRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnToDoById() {
        toDoService.getToDoBy(1L);

        verify(toDoRepository, times(1)).findById(1L);
    }
}