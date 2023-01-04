package com.dudka.testRestService.demo;

import com.dudka.testRestService.demo.model.Employee;
import com.dudka.testRestService.demo.service.EmployeeService;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class EmployeeServiceTest {

    @Autowired
    public EmployeeService employeeService;

    private Optional<Employee> expectedEmployee;
    @BeforeEach
    public void setup() {


        expectedEmployee =
                Optional.of(new Employee(1L, "first", "last", "dima@gmail.com", "23.06.2002"));
    }

    @Test
    @DatabaseSetup("/dataSet/employee.xml")
    void findByIdEmployee() {
        Long id = 1L;

        Optional<Employee> employee = employeeService.findById(id);
        expectedEmployee.ifPresent(value -> assertAll(() -> {
                    assertTrue(employee.isPresent());
                    assertEquals(1, employee.get().getId());
                    assertEquals(expectedEmployee.get(), employee.get());
                }

        ));

    }

}
