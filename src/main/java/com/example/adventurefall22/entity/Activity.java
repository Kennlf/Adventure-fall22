package com.example.adventurefall22.entity;

import lombok.*;

import javax.persistence.*;
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
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int ageLimit;

    private int maxParticipant;

    private int price;

    @ManyToOne
    private Reservation reservation;


    public Activity(int id, String name, int price, int maxParticipant,int ageLimit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxParticipant = maxParticipant;
        this.ageLimit = ageLimit;
    }
}
