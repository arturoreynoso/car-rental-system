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
import com.example.carrentalsystem.model.enums.ReservationStatus;
import com.example.carrentalsystem.repository.CarRepository;
import com.example.carrentalsystem.repository.ReservationRepository;
import com.example.carrentalsystem.service.CarService;
import com.example.carrentalsystem.service.CustomerService;
import com.example.carrentalsystem.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("queryDto")
@RequestMapping(path = "/cars")
public class CarController {
    private final CarService carService;
    private final CustomerService customerService;
    private final ReservationService reservationService;

    @Autowired
    CarController(CarService carService, CustomerService customerService, ReservationService reservationService) {
        this.carService = carService;
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String viewHomePage() {
        return "car/homepage";
    }

    @GetMapping("/reservation")
        public String searchReservation (){
        return "car/provide_reservation_id";
    }

    @GetMapping("/reservation/retrieve_reservation_info")
    public String retrieveReservationById (HttpServletRequest request, Model model){
        Reservation reservation;
        Long reservationId = Long.parseLong(request.getParameter("reservationId"));
        reservation = reservationService.getReservationById(reservationId);
        model.addAttribute("reservation", reservation);
        return "car/retrieve_reservation_info";
    }

    @RequestMapping("/search")
    public String booking(Model model) {
        model.addAttribute("allBrands", Brand.values());
        model.addAttribute("allCarTypes", CarType.values());
        model.addAttribute("queryDto", new QueryDto());
        return "car/search";
    }

    @GetMapping("/search/result_search_car")
    public String getCar(@ModelAttribute("queryDto") QueryDto queryDto, Model model) {
        return getCarPaginated(1,"name", "asc", queryDto, model);
    }

    @GetMapping("/search/result_search_car/page/{pageNo}")
    public String getCarPaginated(@PathVariable (value = "pageNo") int pageNo,
                                  @RequestParam("sortField") String sortField,
                                  @RequestParam("sortDir") String sortDir,
                                  @ModelAttribute("queryDto") QueryDto queryDto,
                                  Model model) {
        int pageSize = 10;
        //List<Car> cars;
        LocalDate fromDate = queryDto.getFrom();
        LocalDate toDate = queryDto.getTo();
        List<Brand> brands = queryDto.getBrands();
        List<CarType> carTypes = queryDto.getCarTypes();
        Page<Car> page = carService.getCarsBetweenDatesAndBrandAndCarType(fromDate, toDate, brands, carTypes, pageNo, pageSize, sortField, sortDir);
        List<Car> cars = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        //cars = carService.getCarsBetweenDatesAndBrandAndCarType(fromDate, toDate.plusDays(1), brands, carTypes);
        model.addAttribute("cars", cars);
        return "car/result_search_car";

    }

    @GetMapping("/search/booking/{id}")
    public String bookingCar(@PathVariable("id") Long id, @SessionAttribute("queryDto") QueryDto queryDto, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("car", car);
        model.addAttribute("customer", new Customer());
        return "car/booking";
    }

    @GetMapping("/search/reservation/{id}")
    public String reservation(@PathVariable("id") Long id,
                              @SessionAttribute("queryDto") QueryDto queryDto,
                              @ModelAttribute("customer") Customer customer, Model model) {
        Car car = carService.getCarById(id);
        System.out.println("XXXXXXXXXXXYYYYYYYYYYY");
        System.out.println(car.getName());
        customerService.addCustomer(customer);
        Reservation reservation = new Reservation(queryDto.getFrom(), queryDto.getTo(), car, customer, ReservationStatus.OPEN);
        reservationService.addReservation(reservation);
        model.addAttribute("reservation", reservation);
        return "car/reservation_info";
    }
}
