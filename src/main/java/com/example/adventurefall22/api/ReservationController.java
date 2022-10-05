package com.example.adventurefall22.api;


import com.example.adventurefall22.dto.ReservationResponse;
import com.example.adventurefall22.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<ReservationResponse> getAllReservations(){
        List<ReservationResponse> response = reservationService.getAllReservations(true);
        return response;
    }
}
