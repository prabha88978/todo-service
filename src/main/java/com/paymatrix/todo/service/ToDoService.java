package com.paymatrix.todo.service;

import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public List<ToDo> getToDos() {
        return toDoRepository.findAll();
    }
}
