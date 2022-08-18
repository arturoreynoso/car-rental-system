package com.example.carrentalsystem.repository;

import java.time.LocalDate;
import java.util.List;
import com.example.carrentalsystem.model.Car;

import com.example.carrentalsystem.model.Employee;
import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.model.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}