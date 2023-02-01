package com.example.services;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServise {

    private final EmployeeRepository employeeRepository;

    public EmployeeServise(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
       return employeeRepository.findAll();
   }

   public Optional<Employee> getById(int id){
        return employeeRepository.findById(id);
   }

   public void save(Employee employee){
        employeeRepository.save(employee);
   }



   public void deleteById(int id){
        employeeRepository.deleteById(id);
   }
}
