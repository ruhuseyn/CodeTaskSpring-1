package com.example.controller;

import com.example.CreateList;
import com.example.dto.EmployeeDto;
import com.example.dto.TaskDto;
import com.example.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@Component
public class EmployeeController {
    private List<EmployeeDto> employeeDtoList = CreateList.createList();
    @GetMapping("/{id}")
    public ResponseEntity<List<EmployeeDto>> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                employeeDtoList.stream().filter(employee ->employee.getId()==id).collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        employeeDtoList.add(employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id){
        return ResponseEntity.ok(EmployeeDto.builder().id(id).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int id){
        employeeDtoList.remove(id);
        return ResponseEntity.ok(EmployeeDto.builder().id(id).build());
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getAllTask(@PathVariable int id){
        return ResponseEntity.of(Optional.ofNullable(employeeDtoList.stream().filter(employee -> employee.getId() == id).
                collect(Collectors.toList()).get(0).getTaskList()));
    }
    @PutMapping("/{id}/tasks/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id,@PathVariable int taskId){
        return ResponseEntity.ok(TaskDto.builder().id(taskId).build());
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<TaskDto> addTask(@PathVariable int id,@RequestBody Task task){
        employeeDtoList.get(id).getTaskList().add(task);
        return ResponseEntity.ok(TaskDto.builder().id(350000).build());
    }

    @DeleteMapping("/{id}/tasks/{taskId}")
    public ResponseEntity<TaskDto> deleteTask(@PathVariable int id,@PathVariable int taskId){
        employeeDtoList.get(id).getTaskList().remove(taskId);
        return ResponseEntity.ok(TaskDto.builder().id(taskId).build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(@RequestParam String name,@RequestParam String surname){
        List<EmployeeDto> result =
        employeeDtoList.stream().filter(employee-> employee.getName().equals(name) && employee.getSurName().equals(surname))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
