package com.example.carrentalsystem.service;

import java.time.LocalDate;
import java.util.List;

import com.example.carrentalsystem.repository.*;
import com.example.carrentalsystem.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCarsBetweenDates(LocalDate from, LocalDate to) {
        return carRepository.findCarAvailableBetweenDates(from, to);
    }
}
