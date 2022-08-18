package com.example.carrentalsystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.repository.*;
import com.example.carrentalsystem.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ZeroCopyHttpOutputMessage;
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

    public List<Car> getCarsBetweenDatesAndBrandAndCarType(LocalDate from, LocalDate to, List<Brand> brands, List<CarType> carTypes) {
        //return carRepository.findCarBetweenDatesAndBrandAndCarType(brands);
        return carRepository.findCarBetweenDatesAndBrandAndCarType(from, to, brands, carTypes);
    }

    public Page<Car> getCarsBetweenDatesAndBrandAndCarType(LocalDate from, LocalDate to, List<Brand> brands, List<CarType> carTypes,
                                                           int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.carRepository.findCarBetweenDatesAndBrandAndCarType(from, to, brands, carTypes, pageable);
    }

    public Car getCarById(Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new IllegalStateException("No exists a car with this id."));
    }

    /*@Override
    public Page<Car> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.carRepository.findAll(pageable);
    }*/
}
