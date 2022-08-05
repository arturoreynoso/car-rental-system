package com.example.carrentalsystem.repository;

import java.time.LocalDate;
import java.util.List;
import com.example.carrentalsystem.model.Car;

import com.example.carrentalsystem.model.Customer;
import com.example.carrentalsystem.model.Reservation;
import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.model.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//get info to existing provide id
    // to cancel provide id
    //to return car
    //to create reservation provide id
}