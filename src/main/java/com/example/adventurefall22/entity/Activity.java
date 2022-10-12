package com.example.adventurefall22.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Activity {

    @Id
    private String name;

    private int price;

    private String instructorName;

    @OneToOne(mappedBy = "activity", cascade = CascadeType.ALL)
    private Reservation reservation;

    public Activity(String name, int price, String instructorName) {
        this.name = name;
        this.price = price;
        this.instructorName = instructorName;
    }
}
