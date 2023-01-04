package com.dudka.testRestService.demo.service.employeeServiceImpl;

import com.dudka.testRestService.demo.model.Employee;
import com.dudka.testRestService.demo.repository.EmployeeRepository;
import com.dudka.testRestService.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }
}
