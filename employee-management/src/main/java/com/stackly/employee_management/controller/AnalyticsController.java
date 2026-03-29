package com.stackly.employee_management.controller;

import com.stackly.employee_management.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService service;

    // Dashboard
    @GetMapping("/dashboard")
    public Map<String, Object> dashboard() {

        return Map.of(
                "headcount", service.getHeadcount(),
                "salaryStats", service.getSalaryStats(),
                "departmentBreakdown", service.getDeptBreakdown()
        );
    }
}