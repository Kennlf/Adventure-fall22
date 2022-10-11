package com.example.adventurefall22.api;


import com.example.adventurefall22.dto.ReservationRequest;
import com.example.adventurefall22.dto.ReservationResponse;
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
    public List<ReservationResponse> getAllReservations(){
        List<ReservationResponse> response = reservationService.getAllReservations();
        return response;
    }

    @GetMapping(path = "/{id}")
    public ReservationResponse getReservationByPhoneNumber(@PathVariable int id) throws Exception {
        return reservationService.findReservationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationService.deleteReservation(id);
    }

    @PostMapping()
    public void makeReservation(@RequestBody ReservationRequest request){
        //reservationService.reserveActivity();
    }
}
