package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.CorporateReservationResponse;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationServiceTest {

    public ReservationService reservationService;

    public static ReservationRepository reservationRepository;

    @BeforeAll
    public static void setupData(@Autowired ReservationRepository reservation_Repository){
        reservationRepository = reservation_Repository;
        List<Reservation> reservations = List.of(
                new Reservation("John doe", "John@john.dk",88888888,15, LocalDate.of(2022, 10,10),null,12345678),
                new Reservation("AA", "A@A.dk",11111111,10, LocalDate.of(2022, 10,15),null,87654321)
        );
        reservationRepository.saveAll(reservations);

    }

    @BeforeEach
    public void setReservationService(){
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    void getAllReservations() {
        List<CorporateReservationResponse> responses = reservationService.getAllReservations();
        assertEquals(2, responses.size());
        assertThat(responses, containsInAnyOrder(hasProperty("contactName", is("John doe")), hasProperty("contactName", is("AA"))));
    }


    @Test
    void findReservationById() {
        CorporateReservationResponse response = reservationService.findReservationById(1);
        assertEquals(1,response.getId());
    }
    @Test
    void deleteByReservationId() {
        reservationRepository.deleteById(1);
        assertEquals(1,reservationRepository.count());
    }
}