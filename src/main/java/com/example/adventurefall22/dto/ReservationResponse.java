package com.example.adventurefall22.dto;

import com.example.adventurefall22.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    private int id;

    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    private Time time;

    private String companyName;
    private int cvr;

    public ReservationResponse(Reservation reservation, Boolean includeAll) {
        this.id = reservation.getId();
        this.name = reservation.getContactName();
        this.date = reservation.getDate();
        this.time = reservation.getTime();
        if (includeAll){
            this.cvr = reservation.getCvr();
            this.companyName = reservation.getCompanyName();
        }
    }
}
