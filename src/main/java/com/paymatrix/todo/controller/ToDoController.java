package com.paymatrix.todo.controller;

import com.paymatrix.todo.controller.dto.ToDoDto;
import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getToDos(){
        List<ToDo> toDos = toDoService.getToDos();
        return ResponseEntity.status(HttpStatus.OK).body(toDos);
    }
}
