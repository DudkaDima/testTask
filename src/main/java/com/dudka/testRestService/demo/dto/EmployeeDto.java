package com.dudka.testRestService.demo.dto;

import com.dudka.testRestService.demo.dto.mapper.MapEmployeeToDto;
import com.dudka.testRestService.demo.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Integer age;


    public EmployeeDto(Optional<Employee> employee) {
        if (employee.isPresent()) {
            this.id = employee.get().getId();
            this.firstName = employee.get().getFirstName();
            this.lastName = employee.get().getLastName();
            this.age = MapEmployeeToDto.ageOfEmployee(LocalDate.parse(employee.get().getBirthday(), MapEmployeeToDto.FORMATTER));
            this.email = employee.get().getEmail();
        }


    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
