package com.paymatrix.todo.model;

import com.paymatrix.todo.controller.dto.ToDoDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date date;
    private Boolean completed;

    public ToDo(String text, Date date, boolean completed) {
        this.text = text;
        this.date = date;
        this.completed = completed;
    }

    public static ToDo from(ToDoDto toDoDto) {
        return new ToDo(toDoDto.getText(), toDoDto.getDate(), false);
    }

}
