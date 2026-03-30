package com.stackly.employee_management.controller;

import com.stackly.employee_management.entity.Employee;
import com.stackly.employee_management.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    // GET ALL
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("API call: GET /api/employees");
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        logger.info("API call: GET /api/employees/id");
        return service.getById(id);
    }

    // CREATE
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.create(employee);
    }

    // UPDATE
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    // DELETE
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }

    // SEARCH BY DEPARTMENT
    @GetMapping("/search")
    public List<Employee> searchByDepartment(@RequestParam String department) {
        return service.search(department);
    }

}