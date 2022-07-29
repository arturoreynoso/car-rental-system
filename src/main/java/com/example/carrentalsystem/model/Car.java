package com.example.carrentalsystem.model;
import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.model.enums.Color;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeCar")
    private CarType carType;

    @Column(name = "modelYear")
    private int modelYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "brandCar")
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "colorCar")
    private Color color;

    @Column(name = "seatingCapacity")
    private int seatingCapacity;

    @Column(name = "plateNumber")
    private String plateNumber;

    @Column(name = "rate")
    private double rate;
}
