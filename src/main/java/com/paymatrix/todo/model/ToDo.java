package com.paymatrix.todo.model;

import com.paymatrix.todo.controller.dto.ToDoDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String text;
    private final Date date;
    private final boolean completed;

    public static ToDo from(ToDoDto toDoDto) {
        return new ToDo(toDoDto.getText(), toDoDto.getDate(), false);
    }
}
