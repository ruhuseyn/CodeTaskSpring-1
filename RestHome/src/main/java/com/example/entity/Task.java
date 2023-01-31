package com.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {

    private int id;
    private String title;
    private String description;
    private String dueDate;

}
