package com.stackly.employee_management.service;

import com.stackly.employee_management.entity.Employee;
import com.stackly.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnalyticsService {

    @Autowired
    private EmployeeRepository repository;

    // Total Employees
    public long getHeadcount() {
        return repository.count();
    }

    // Salary Stats
    public Map<String, Double> getSalaryStats() {
        List<Employee> employees = repository.findAll();

        double total = employees.stream().mapToDouble(Employee::getSalary).sum();
        double avg = employees.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        double max = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        double min = employees.stream().mapToDouble(Employee::getSalary).min().orElse(0);

        Map<String, Double> stats = new HashMap<>();
        stats.put("total", total);
        stats.put("average", avg);
        stats.put("max", max);
        stats.put("min", min);

        return stats;
    }

    // Department-wise Count
    public Map<String, Long> getDeptBreakdown() {
        List<Employee> employees = repository.findAll();

        Map<String, Long> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.getDepartment(),
                    map.getOrDefault(e.getDepartment(), 0L) + 1);
        }

        return map;
    }
}