package com.paymatrix.todo.controller;

import com.paymatrix.todo.controller.dto.ToDoDto;
import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/todos")
    public ResponseEntity<Object> save(@RequestBody ToDoDto toDoDto){
        ToDo toDo =  ToDo.from(toDoDto);
        ToDo response =  toDoService.save(toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
