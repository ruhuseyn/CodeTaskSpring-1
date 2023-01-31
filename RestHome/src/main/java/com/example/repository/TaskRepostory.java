package com.example.repository;

import com.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepostory extends JpaRepository<Task,Integer> {
}
