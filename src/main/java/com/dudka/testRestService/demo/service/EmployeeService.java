package com.dudka.testRestService.demo.service;

import com.dudka.testRestService.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findById(Long id);


}
