package com.paymatrix.todo.service;

import com.paymatrix.todo.controller.dto.ToDoDto;
import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

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

    @Test
    void shouldUpdateToDoById() {
        ToDo toDo = new ToDo("Programming", new Date(), false);
        ToDoDto toDoDto = new ToDoDto("Programming", new Date(), true);
        when(toDoRepository.getById(1L)).thenReturn(toDo);

        toDoService.updateToDoBy(1L, toDoDto);

        verify(toDoRepository, times(1)).getById(1L);
    }

    @Test
    void shouldDeleteToDoById() {
        toDoService.deleteById(1L);

        verify(toDoRepository, times(1)).deleteById(1L);
    }
}