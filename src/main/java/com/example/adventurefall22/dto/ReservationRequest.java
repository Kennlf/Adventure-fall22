package com.example.adventurefall22.dto;


import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.OneToMany;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {


    private String contactName;


    private String email;


    private int phoneNumber;


    private int age;


    private int numberOfParticipants;


    private List<Activity> activityList;


    private LocalDate date;


    private Time time;


    private String companyName;
    private int cvr;


    public static Reservation getReservationEntity(ReservationRequest rr) {
        return new Reservation(rr.contactName, rr.email, rr.phoneNumber, rr.age,
                 rr.date, rr.companyName, rr.cvr);
    }


    public ReservationRequest(Reservation reservation) {
        this.contactName = reservation.getContactName();
        this.email = reservation.getEmail();
        this.phoneNumber = reservation.getPhoneNumber();
        this.age = reservation.getAge();
        this.date = reservation.getDate();
        this.companyName = reservation.getCompanyName();
        this.cvr = reservation.getCvr();
    }
}