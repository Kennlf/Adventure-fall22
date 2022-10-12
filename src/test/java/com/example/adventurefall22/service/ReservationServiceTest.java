package com.example.adventurefall22.service;

import com.example.adventurefall22.dto.ReservationResponse;
import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Customer;
import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ActivityRepository;
import com.example.adventurefall22.repository.CustomerRepository;
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
    public static CustomerRepository customerRepository;
    public static ActivityRepository activityRepository;

    @BeforeAll
    public static void setupData(@Autowired ReservationRepository reservation_Repository, @Autowired CustomerRepository customer_Repository,@Autowired ActivityRepository activity_Repository){
        reservationRepository = reservation_Repository;
        customerRepository = customer_Repository;
        activityRepository = activity_Repository;

        customerRepository.deleteAll();
        activityRepository.deleteAll();

        Activity a1 = new Activity("paintball", 100, "Ed");
        Activity a2 = new Activity("minigolf", 500, "Eddy");
        Customer c1 = new Customer(11223344, "John Doe", "email@mail.dk");
        Customer c2 = new Customer(55667788, "Jane Doe", "email@mail.com");
        List<Reservation> reservations = List.of(
                new Reservation(a1, c1, LocalDate.of(2022, 10,10),3),
                new Reservation(a2, c2, LocalDate.of(2023, 10,10),3)

        );
        reservationRepository.saveAll(reservations);

    }

    @BeforeEach
    public void setReservationService(){
        reservationService = new ReservationService(reservationRepository, activityRepository, customerRepository);
    }

    @Test
    void reserveActivity() {
        reservationService.reserveActivity("paintball", 11223344, LocalDate.of(2022, 12, 10), 5);
        List<ReservationResponse> responses = reservationService.getAllReservations();
        assertEquals(3, responses.size());
    }

    /*
    @Test
    void getAllReservations() {
        List<ReservationResponse> responses = reservationService.getAllReservations();
        assertEquals(2, responses.size());
        assertThat(responses, containsInAnyOrder(hasProperty("contactName", is("John doe")), hasProperty("contactName", is("AA"))));
    }

   *//* void editPrivateReservation() throws Exception {
        //Create a member, just as a quick way to get a MemberRequest --> Observe new address for m1
        PrivateReservationRequest request = new PrivateReservationRequest(new Reservation("John doe", "John@john.dk",88888888,15, LocalDate.of(2022, 10,10),null,12345678));
        reservationService.editPrivateReservation(request,1);
        //find m1 and verify that address has been changed
        PrivateReservationResponse response = reservationService.findPrivateReservationById(1);
        assertEquals("xxxx", response.getStreet());
        assertEquals("yyyy", response.getCity());
        assertEquals("2000", response.getZip());
    }*//*


    @Test
    void findReservationById() {
        ReservationResponse response = reservationService.findReservationById(1);
        assertEquals(1,response.getId());
    }
    @Test
    void deleteByReservationId() {
        reservationRepository.deleteById(1);
        assertEquals(1,reservationRepository.count());
    }*/
}