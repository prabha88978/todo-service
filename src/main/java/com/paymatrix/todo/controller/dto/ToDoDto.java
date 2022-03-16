package com.paymatrix.todo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {
    private String text;
    private Date date;
    private Boolean completed;
}
