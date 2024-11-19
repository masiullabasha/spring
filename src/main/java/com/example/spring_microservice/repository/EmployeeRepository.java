package com.example.spring_microservice;

import com.example.spring_microservice.entity.Employee;
import com.example.spring_microservice.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldSaveAndFindEmployee() {
        Employee employee = new Employee("John", "Doe", "Engineering");
        employeeRepository.save(employee);

        Employee found = employeeRepository.findById(employee.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getFirstName()).isEqualTo("John");
    }
}
