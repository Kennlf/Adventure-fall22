package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorporateReservationRequest {

    private String contactName;

    private String email;

    private int phoneNumber;

    private int age;

    private List<Activity> activityList;

    private LocalDate date;

    private String companyName;

    private int cvr;

    public static Reservation getReservationEntity(CorporateReservationRequest rr){
        return new Reservation(rr.contactName, rr.email, rr.phoneNumber, rr.age, rr.date, rr.companyName,rr.cvr);
    }

    public CorporateReservationRequest(Reservation reservation) {
        this.contactName = reservation.getContactName();
        this.email = reservation.getEmail();
        this.phoneNumber = reservation.getPhoneNumber();
        this.age = reservation.getAge();
        this.date = reservation.getDate();
        this.companyName = reservation.getCompanyName();
        this.cvr = reservation.getCvr();
    }
}
