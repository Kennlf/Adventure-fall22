package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateReservationRequest {
    private String contactName;

    private String email;

    private int phoneNumber;

    private int age;

    private LocalDate date;

    private List<Activity> activityList;


    public static Reservation getReservationEntity(PrivateReservationRequest rr){
        return new Reservation(rr.contactName, rr.email, rr.phoneNumber, rr.age, rr.date);
    }

    public PrivateReservationRequest(Reservation reservation) {
        this.contactName = reservation.getContactName();
        this.email = reservation.getEmail();
        this.phoneNumber = reservation.getPhoneNumber();
        this.age = reservation.getAge();
        this.date = reservation.getDate();
    }
}
