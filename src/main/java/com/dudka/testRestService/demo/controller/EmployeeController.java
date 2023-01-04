package com.dudka.testRestService.demo.controller;

import com.dudka.testRestService.demo.dto.EmployeeDto;
import com.dudka.testRestService.demo.dto.mapper.MapEmployeeToDto;
import com.dudka.testRestService.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity getEmployee(@RequestParam(name = "id") Long id) {
        Optional<EmployeeDto> employeeDto = MapEmployeeToDto.map(employeeService.findById(id));
        return ResponseEntity.ok(employeeDto);
    }


}
