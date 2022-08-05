package com.example.carrentalsystem.repository;

import java.time.LocalDate;
import java.util.List;
import com.example.carrentalsystem.model.Car;

import com.example.carrentalsystem.model.enums.Brand;
import com.example.carrentalsystem.model.enums.CarType;
import com.example.carrentalsystem.model.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT j FROM Car j WHERE j.carType = ?1")
    public List<Car> findCarByCarType(CarType carType);

    @Query("SELECT j FROM Car j WHERE j.brand = ?1")
    public List<Car> findCarByBrand(Brand brand);

    @Query("SELECT j FROM Car j WHERE j.rate >= :rate1 AND j.rate <= :rate2")
    public List<Car> findCarBetweenRate1AndRate2(@Param("rate1") int rate1, @Param("rate2") int rate2);

    @Query("SELECT j FROM Car j WHERE j.carType = ?1 AND j.brand = ?2")
    public List<Car> findCarByCarTypeAndBrand(CarType cartype, Brand brand);

    @Query(value = "SELECT * FROM car WHERE id IN ( SELECT id FROM car WHERE id IN (SELECT carid FROM reservation WHERE ((reservation.hiredate, reservation.returndate) OVERLAPS (:from, :to) AND reservation.carid = id)));", nativeQuery = true)
    public List<Car> findCarAvailableBetweenDates(LocalDate from, LocalDate to);
    //"SELECT * FROM car WHERE id = (SELECT id FROM car WHERE NOT EXISTS (SELECT * FROM reservation WHERE (hireDate >=:from OR returnDate >=:from) AND (hireDate<=:to OR returnDate <=:to) AND reservation.carId = car.id))"
}
