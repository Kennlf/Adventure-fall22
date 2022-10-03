package com.example.adventurefall22.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private int phoneNumber;

    private int age;

    private int numberOfParticipants;

    private LocalDate date;

    private Time time;

    public Reservation(String name, String email, int phoneNumber, int age, int numberOfParticipants, LocalDate date, Time time) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.numberOfParticipants = numberOfParticipants;
        this.date = date;
        this.time = time;
    }
}
