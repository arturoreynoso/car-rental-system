package com.example.carrentalsystem.controller;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.carrentalsystem.model.Car;
import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Reservation;
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
    public String booking() {
        return "car/booking";
    }

    @GetMapping("/search_result")
    public String getCar(HttpServletRequest request, Model model) {
        List<Car> cars;
        String fromD, toD;
        fromD = request.getParameter("from");
        toD = request.getParameter("to");
        LocalDate fromDate = LocalDate.parse(fromD);
        LocalDate toDate = LocalDate.parse(toD);
        cars = carService.getAvailableCarsBetweenDates(fromDate, toDate.plusDays(1));
        model.addAttribute("cars", cars);
        return "car/result_search_car";
    }
}
