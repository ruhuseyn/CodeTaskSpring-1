package com.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    private int id;
    private String name;
    private String surName;
    private List<Task> taskList;
}
