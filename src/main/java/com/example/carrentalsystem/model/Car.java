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
@Table(name = "car", schema = "public")
public class Car {

    public Car(String name, CarType carType, int modelYear, Brand brand, Color color, int seatingCapacity, String plateNumber, int rate) {
        this.name = name;
        this.carType = carType;
        this.modelYear = modelYear;
        this.brand = brand;
        this.color = color;
        this.seatingCapacity = seatingCapacity;
        this.plateNumber = plateNumber;
        this.rate = rate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "typecar")
    private CarType carType;

    @Column(name = "modelyear")
    private int modelYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "brandcar")
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "colorcar")
    private Color color;

    @Column(name = "seatingcapacity")
    private int seatingCapacity;

    @Column(name = "platenumber")
    private String plateNumber;

    @Column(name = "rate")
    private double rate;
}
