package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Employee {

    private int id;
    private String name;
    private String surName;
    private List<Task> taskList;
}
