package com.example.adventurefall22.api;


import com.example.adventurefall22.dto.CorporateReservationResponse;
import com.example.adventurefall22.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/reservations")
public class ReservationController {

    ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<CorporateReservationResponse> getAllReservations(){
        List<CorporateReservationResponse> response = reservationService.getAllReservations();
        return response;
    }

    @GetMapping(path = "/{id}")
    CorporateReservationResponse getReservationByPhoneNumber(@PathVariable int id) throws Exception {
        return reservationService.findReservationById(id);
    }
}
