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
@Table(name = "reservation", schema = "public")
public class Reservation {

    public Reservation(LocalDate hireDate, LocalDate returnDate, Car car, Customer customer, ReservationStatus status) {
        this.hireDate = hireDate;
        this.returnDate = returnDate;
        this.car = car;
        this.customer = customer;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "hiredate", columnDefinition = "DATE")
    private LocalDate hireDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "returndate", columnDefinition = "DATE")
    private LocalDate returnDate;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "carid")
    private Car car;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;
}
