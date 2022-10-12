package com.example.adventurefall22.dto;

import com.example.adventurefall22.dto.ActivityResponse;
import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Customer;
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
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    private int resId;

    private String contactName;

    private String activityName;

    private String instructorName;

    private LocalDate date;

    private int numberOfParticipants;

    private Activity activity;

    private Customer customer;

    public ReservationResponse(Reservation reservation, Boolean includeAll) {
        this.resId = reservation.getId();
        this.customer = reservation.getCustomer();
        this.contactName = customer.getName();
        this.activity = reservation.getActivity();
        this.activityName = activity.getName();
        this.instructorName = activity.getInstructorName();
        this.date = reservation.getDate();
        this.numberOfParticipants = reservation.getNumberOfParticipants();

        if(includeAll) {
            this.activity = reservation.getActivity();
            this.customer = reservation.getCustomer();
        }
    }
}


