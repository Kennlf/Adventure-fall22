package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.CorporateReservationResponse;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<CorporateReservationResponse> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<CorporateReservationResponse> response = reservations.stream().map(res ->
                new CorporateReservationResponse(res)).collect(Collectors.toList());
        return response;
    }

    public CorporateReservationResponse findReservationById(int id) {
        Reservation found = reservationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Reservation not found"));
        return new CorporateReservationResponse(found);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
