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
@Table(name = "customer", schema = "public")
public class Customer extends UserEntity {

}
