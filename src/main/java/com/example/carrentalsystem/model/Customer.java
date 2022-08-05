package com.example.carrentalsystem.model;
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
@Table(name = "customer")
public class Customer {

    public Customer(String name, String lastName, String phoneNumber, String username) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "username")
    private String username;

}
