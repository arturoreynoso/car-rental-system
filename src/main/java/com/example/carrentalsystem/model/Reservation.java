package com.example.carrentalsystem.model;

import java.time.LocalDateTime;

import com.example.carrentalsystem.model.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hireDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime initialDate;

    @Column(name = "returnDate", columnDefinition = "TIMESTAMP")
    private LocalDateTime returnDate;

    @Column(name = "carId")
    private Long carId;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "rate")
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ReservationStatus status;
}
