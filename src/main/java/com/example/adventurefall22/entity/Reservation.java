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

    @OneToOne(cascade = CascadeType.ALL)
    private Activity activity;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private LocalDate date;

    private int numberOfParticipants;

    public Reservation(Activity activity, Customer customer, LocalDate date, int numberOfParticipants) {
        this.activity = activity;
        this.date = date;
        this.customer = customer;
        this.numberOfParticipants = numberOfParticipants;
    }
}
