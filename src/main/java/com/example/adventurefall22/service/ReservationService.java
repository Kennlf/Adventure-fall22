package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.ReservationResponse;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> getAllReservations(boolean include) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponse> response = reservations.stream().map(res ->
                new ReservationResponse(res, include)).collect(Collectors.toList());
        return response;
    }
}
