package com.paymatrix.todo.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ToDoDto {
    private String text;
    private Date date;
}
