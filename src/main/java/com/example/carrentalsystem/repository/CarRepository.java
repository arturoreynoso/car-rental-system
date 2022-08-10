package com.example.carrentalsystem.repository;

import java.time.LocalDate;
import java.util.ArrayList;
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


    @Query("SELECT j FROM Car j WHERE j.rate >= :rate1 AND j.rate <= :rate2")
    public List<Car> findCarBetweenRate1AndRate2(@Param("rate1") int rate1, @Param("rate2") int rate2);

    @Query("SELECT c FROM Car c WHERE c.id IN (SELECT i.id FROM Car i WHERE i.id NOT IN (SELECT r.car.id FROM Reservation r WHERE r.hireDate <= :to AND r.returnDate >= :from AND r.car.id = i.id))")
    public List<Car> findCarAvailableBetweenDates(LocalDate from, LocalDate to);

    @Query("SELECT c FROM Car c WHERE c.id IN (SELECT i.id FROM Car i WHERE i.id NOT IN (SELECT r.car.id FROM Reservation r WHERE r.hireDate <= :to AND r.returnDate >= :from AND r.car.id = i.id)) AND c.brand IN :brands")
    public List<Car> findCarBetweenDatesAndBrandAndCarType(LocalDate from, LocalDate to, @Param("brands") List<Brand> brands);

    //funciona @Query(value = "SELECT * FROM car WHERE id IN ( SELECT id FROM car WHERE id NOT IN (SELECT carid FROM reservation WHERE (reservation.hiredate, reservation.returndate) OVERLAPS (:from, :to) AND reservation.carid = id));", nativeQuery = true)

    //"SELECT * FROM car WHERE id = (SELECT id FROM car WHERE NOT EXISTS (SELECT * FROM reservation WHERE (hireDate >=:from OR returnDate >=:from) AND (hireDate<=:to OR returnDate <=:to) AND reservation.carId = car.id))"

    //@Query(value = "SELECT * FROM car WHERE id IN ( SELECT id FROM car WHERE id IN (SELECT carid FROM reservation WHERE ((reservation.hiredate, reservation.returndate) OVERLAPS (:from, :to) AND reservation.carid = id))) AND typecar IN :carTypes AND brandcar IN :brands", nativeQuery = true)
    //@Query(value = "SELECT * FROM car WHERE brandcar IN :brands", nativeQuery = true)
    //public List<Car> findCarBetweenDatesAndBrandAndCarType(@Param("brands") List<Brand> brands);
    //public List<Car> findCarBetweenDatesAndBrandAndCarType(@Param("from") LocalDate from, @Param("to") LocalDate to, @Param("brands") List<Brand> brands, @Param("carTypes") List<CarType> carTypes);

}
