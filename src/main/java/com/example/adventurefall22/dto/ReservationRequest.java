package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

    private String name;

    private String email;

    private int phoneNumber;

    private int age;

    private int numberOfParticipants;

    private LocalDate date;

    private Time time;

    public static Reservation getReservationEntity(ReservationRequest rr){
        return new Reservation(rr.name, rr.email, rr.phoneNumber, rr.age, rr.numberOfParticipants, rr.date, rr.time);
    }

    public ReservationRequest(Reservation reservation) {
        this.name = reservation.getName();
        this.email = reservation.getEmail();
        this.phoneNumber = reservation.getPhoneNumber();
        this.age = reservation.getAge();
        this.numberOfParticipants = reservation.getNumberOfParticipants();
        this.date = reservation.getDate();
        this.time = reservation.getTime();
    }
}
