package com.stackly.employee_management.service;

import com.stackly.employee_management.entity.Employee;
import com.stackly.employee_management.exception.ResourceNotFoundException;
import com.stackly.employee_management.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    // GET ALL
    public List<Employee> getAll() {
        logger.info("Fetching all employees");
        return repository.findAll();
    }

    // GET BY ID
    public Employee getById(Long id) {
        logger.info("Fetching employee with id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Employee not found with id: {}", id);
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });
    }

    // CREATE
    public Employee create(Employee employee) {
        logger.info("Creating employee: {}", employee.getName());
        return repository.save(employee);
    }

    // UPDATE
    public Employee update(Long id, Employee employee) {
        logger.info("Updating employee with id: {}", id);

        Employee existing = getById(id);

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {
        logger.warn("Deleting employee with id: {}", id);
        repository.deleteById(id);
    }

    // SEARCH (by department)
    public List<Employee> search(String department) {
        return repository.findByDepartment(department);
    }
}