package com.example.carrentalsystem.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.carrentalsystem.model.Car;
import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.QueryDto;
import com.example.carrentalsystem.model.Reservation;
import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.repository.CarRepository;
import com.example.carrentalsystem.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/booking")
public class CarController {
    private final CarService carService;

    @Autowired
    CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping()
    public String booking(Model model) {
        model.addAttribute("allBrands", Brand.values());
        model.addAttribute("allCarTypes", CarType.values());
        model.addAttribute("queryDto", new QueryDto());
        return "car/booking";
    }

    @GetMapping("/search_result")
    public String getCar(@ModelAttribute("queryDto") QueryDto queryDto, Model model) {
        List<Car> cars;
        LocalDate fromDate = queryDto.getFrom();
        LocalDate toDate = queryDto.getTo();
        List<Brand> brands = queryDto.getBrands();
        List<CarType> carTypes = queryDto.getCarTypes();
        System.out.println(brands.toString());
        cars = carService.getCarsBetweenDatesAndBrandAndCarType(fromDate, toDate.plusDays(1), brands);
        //cars = carService.getCarsBetweenDatesAndBrandAndCarType(fromDate, toDate.plusDays(1), brands, carTypes);
        model.addAttribute("cars", cars);
        return "car/result_search_car";
    }
}
