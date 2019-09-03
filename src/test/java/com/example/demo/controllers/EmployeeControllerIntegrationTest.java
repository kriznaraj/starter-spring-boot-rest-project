package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = EmployeeController.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerIntegrationTest {

    @MockBean
    private EmployeeService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void init() {
    }

    @Test
    public void createEmployee() throws Exception {
        final Integer id = 1;
        final var returnedEmployee = new Employee();
        returnedEmployee.id = id;
        when(this.service.get(id)).thenReturn(Optional.of(returnedEmployee));

        mockMvc.perform(get("/employees/" + id))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().bytes(objectMapper.writeValueAsBytes(returnedEmployee)));
    }
}