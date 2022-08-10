package com.example.carrentalsystem.model;

import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class QueryDto {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate from;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate to;
    private List<Brand> brands;
    private List<CarType> carTypes;


    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Brand> getBrands() {
        return this.brands;
    }

    public void setCarTypes(List<CarType> carTypes) {
        this.carTypes = carTypes;
    }

    public List<CarType> getCarTypes() {
        return this.carTypes;
    }
}
