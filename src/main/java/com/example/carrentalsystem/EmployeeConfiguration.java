package com.example.carrentalsystem;

import java.util.ArrayList;

import com.example.carrentalsystem.model.Employee;
import com.example.carrentalsystem.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EmployeeConfiguration {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee employee1 = new Employee(
                    "Arturo",
                    "Reynoso",
                    "5532690746",
                    "arturo",
                    "arturo@gmail.com",
                    "Employee",
                    passwordEncoder.encode("arturo")
            );
            repository.saveAll(
                    new ArrayList<Employee>() {{
                        add(employee1);
                    }}
            );
        };
    }
}
