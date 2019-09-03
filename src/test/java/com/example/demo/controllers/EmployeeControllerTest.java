package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController controller;

    @Mock
    private EmployeeService service;

    @Before
    public void init() {
    }

    @Test
    public void getEmployee() {
        final Integer id = 1;
        final var returnedEmployee = new Employee();
        returnedEmployee.id = id;
        when(this.service.get(id)).thenReturn(Optional.of(returnedEmployee));

        final ResponseEntity<Employee> result = this.controller.getEmployee(id);

        assertThat(result.getBody(), is(returnedEmployee));
    }
}