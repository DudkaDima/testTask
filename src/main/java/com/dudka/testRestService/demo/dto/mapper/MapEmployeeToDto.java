package com.dudka.testRestService.demo.dto.mapper;

import com.dudka.testRestService.demo.dto.EmployeeDto;
import com.dudka.testRestService.demo.model.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MapEmployeeToDto {
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d.MM.yyyy");

    public static Optional<EmployeeDto> map(Optional<Employee> employee) {
        return Optional.of(new EmployeeDto(employee));
    }

    public static int ageOfEmployee(LocalDate employeeBirthday) {
        return Math.abs(Period.between(LocalDate.now(), employeeBirthday).getYears());
    }
}
