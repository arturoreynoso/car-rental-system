package com.example.carrentalsystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.carrentalsystem.model.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    public Reservation(LocalDate initialDate, LocalDate returnDate, Car car, Customer customer, int rate, ReservationStatus status) {
        this.initialDate = initialDate;
        this.returnDate = returnDate;
        this.car = car;
        this.customer = customer;
        this.rate = rate;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "hiredate", columnDefinition = "DATE")
    private LocalDate initialDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "returndate", columnDefinition = "DATE")
    private LocalDate returnDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carid")
    private Car car;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @Column(name = "rate")
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;
}
