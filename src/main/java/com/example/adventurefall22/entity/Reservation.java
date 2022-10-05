package com.example.adventurefall22.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private String contactName;

    private String email;

    private int phoneNumber;

    private int age;

    private String companyName;
    private int cvr;

    private int numberOfParticipants;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Activity> activities = new ArrayList<>();

    private LocalDate date;

    //private Time time;

    public void addActivity(Activity activity){
        activities.add(activity);
        activity.setReservation(this);
    }

    public Reservation(String contactName, String email, int phoneNumber, int age, int numberOfParticipants, LocalDate date, String companyName, int cvr) {
        this.contactName = contactName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.numberOfParticipants = numberOfParticipants;
        this.date = date;
        //this.time = time;
        this.companyName = companyName;
        this.cvr = cvr;
    }
}
