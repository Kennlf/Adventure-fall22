package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.ReservationResponse;
import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ActivityRepository;
import com.example.adventurefall22.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ActivityRepository activityRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponse> response = reservations.stream().map(res ->
                new ReservationResponse(res, true)).collect(Collectors.toList());
        return response;
    }

    public ReservationResponse findReservationById(int id) {
        Reservation found = reservationRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Reservation not found"));
        return new ReservationResponse(found, true);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }

    public void reserveActivity(int id, LocalDate date, Reservation res) {
        int id1, id2, id3, id4;
        if(res.getActivities() != null) {
            List<Activity> test = res.getActivities();
            id1 = test.get(0).getId();
            id2 = test.get(1).getId();
            id3 = test.get(2).getId();
            id4 = test.get(3).getId();
        }


        if(activityRepository.existsByIdAndReservationDate(id, date)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Activity already booked");
        }

        Reservation reservation = new Reservation();
        reservationRepository.save(reservation);
    }
}
