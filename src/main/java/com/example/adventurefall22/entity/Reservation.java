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

    private String name;

    private String email;

    private int phoneNumber;

    private int age;

    private int numberOfParticipants;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Activity> activityList = new ArrayList<>();

    private LocalDate date;

    private Time time;

    public void addActivity(Activity activity){
        activityList.add(activity);
        activity.setReservation(this);
    }

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
