package com.example.adventurefall22.dto;

import com.example.adventurefall22.dto.ActivityResponse;
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

    private int id;

    private String contactName;

    private String email;

    private int phoneNumber;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;

    private String companyName;
    private int cvr;

    List<ActivityResponse> activities;

    public ReservationResponse(Reservation reservation, Boolean includeAll) {
        this.id = reservation.getId();
        this.contactName = reservation.getContactName();
        this.date = reservation.getDate();
        if (includeAll) {
            this.cvr = reservation.getCvr();
            this.companyName = reservation.getCompanyName();
            this.email = reservation.getEmail();
            this.phoneNumber = reservation.getPhoneNumber();
        }

        if (reservation.getActivities().size() > 0) {
            activities = reservation.getActivities().stream().map(a -> ActivityResponse.builder()
                    .id(a.getId())
                    .name(a.getName())
                    .price(a.getPrice())
                    .maxParticipant(a.getMaxParticipant())
                    .ageLimit(a.getAgeLimit())
                    .build()).collect(Collectors.toList());
        }
    }
}


