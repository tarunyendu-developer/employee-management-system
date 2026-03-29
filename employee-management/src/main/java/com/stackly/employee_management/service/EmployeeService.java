package com.stackly.employee_management.service;

import com.stackly.employee_management.entity.Employee;
import com.stackly.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // GET ALL
    public List<Employee> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public Employee getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // CREATE
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    // UPDATE
    public Employee update(Long id, Employee employee) {
        Employee existing = getById(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // SEARCH (by department)
    public List<Employee> search(String department) {
        return repository.findByDepartment(department);
    }
}