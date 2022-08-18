package com.example.carrentalsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="userentity", schema="public")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserEntity implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    @Column(name="name") @NotBlank(message="Can't be empty.")
    private String name;

    @Column(name="lastname") @NotBlank(message="Can't be empty.")
    private String lastName;

    @Column(name="phonenumber") @NotBlank(message="Can't be empty.")
    private String phoneNumber;

    @Column(name="username") @NotBlank(message="Can't be empty.")
    private String username;

    @Column(name="email") @NotBlank(message="Can't be empty.") @Email(message="Must provide a valid email.")
    private String email;

    @Column(name="role") @NotBlank(message="Can't be empty.")
    private String role;

    @Column(name="password") @NotBlank(message="Can't be empty.")
    private String password;


    public UserEntity(String name,
                String lastName,
                String phoneNumber,
                String username,
                String email,
                String role,
                String password) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public UserEntity() {
        super();
    }
}