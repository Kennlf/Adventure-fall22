package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.ReservationResponse;
import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Customer;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ActivityRepository;
import com.example.adventurefall22.repository.CustomerRepository;
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
    CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository, ActivityRepository activityRepository, CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.activityRepository = activityRepository;
        this.customerRepository = customerRepository;
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

    public ReservationResponse reserveActivity(String activityId, int phoneNumber, LocalDate date, int numberOfParticipants) {

       if(activityRepository.existsByNameAndReservation_Date(activityId, date)) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Activity already booked");

       }
       Activity activity = activityRepository.findById(activityId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Customer customer = customerRepository.findById(phoneNumber)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));


        Reservation reservation = new Reservation(activity, customer, date, numberOfParticipants);
        reservationRepository.save(reservation);
        return new ReservationResponse(reservation, false);
    }
}
