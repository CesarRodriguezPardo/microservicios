package com.example.demo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String firstSurname;
    private String secondSurname;
    private String rut;
    private String email;
    private String password;
    private String phone;
    private int age;

    private Boolean verified;
    private int role; // 1 for customer, 2 for employee
}

