package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Customer;
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

    private int resId;

    private Activity activity;

    private Customer customer;

    private LocalDate date;

    private int numberOfParticipants;

}