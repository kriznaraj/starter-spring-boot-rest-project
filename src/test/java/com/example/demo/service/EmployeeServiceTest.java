package com.example.demo.service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    public void shouldGetEmployee() {
        final Integer id = 1;
        final var employee = new Employee();
        employee.id = id;
        when(this.employeeRepository.findById(id)).thenReturn(Optional.of(employee));

        final var optionalEmployee = employeeService.get(id);

        assertThat(optionalEmployee.get(), is(employee));
    }
}