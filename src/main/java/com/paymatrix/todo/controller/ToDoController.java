package com.paymatrix.todo.controller;

import com.paymatrix.todo.controller.dto.ToDoDto;
import com.paymatrix.todo.model.ToDo;
import com.paymatrix.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @PostMapping("/todos")
    public ResponseEntity<Object> save(@RequestBody ToDoDto toDoDto) {
        ToDo toDo = ToDo.from(toDoDto);
        ToDo response = toDoService.save(toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ToDo>> getToDos() {
        List<ToDo> toDos = toDoService.getToDos();
        return ResponseEntity.status(HttpStatus.OK).body(toDos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Optional<ToDo>> getToDoBy(@PathVariable Long id) {
        Optional<ToDo> toDo = toDoService.getToDoBy(id);
        if (toDo.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(toDo);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<ToDo> updateBy(@PathVariable Long id, @RequestBody ToDoDto toDoDto) {
        ToDo updatedToDo = toDoService.updateToDoBy(id, toDoDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedToDo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        toDoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
