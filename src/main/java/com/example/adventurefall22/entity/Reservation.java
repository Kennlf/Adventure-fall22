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

    @OneToOne
    private Activity activity;

    private LocalDate date;

    @ManyToOne
    private Customer customer;

    private int numberOfParticipants;

}
