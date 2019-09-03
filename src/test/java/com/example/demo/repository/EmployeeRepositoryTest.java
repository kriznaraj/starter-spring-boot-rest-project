package com.example.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldGetEmployee() {
        final Integer id = 1;

        final var optionalEmployee = employeeRepository.findById(id);

        assertThat(optionalEmployee, emptyOptional());
    }
}