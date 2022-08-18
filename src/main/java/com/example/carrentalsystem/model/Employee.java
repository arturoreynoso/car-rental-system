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
@Entity
@Table(name = "employee", schema = "public")
public class Employee extends UserEntity {

    public Employee(String name,
                      String lastName,
                      String phoneNumber,
                      String username,
                      String email,
                      String role,
                      String password) {
        super(name, lastName, phoneNumber, username, email, role, password);
    }
}