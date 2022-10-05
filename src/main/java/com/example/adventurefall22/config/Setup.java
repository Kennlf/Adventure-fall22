package com.example.adventurefall22.config;

import com.example.adventurefall22.entity.Reservation;
import com.example.adventurefall22.repository.ReservationRepository;
import com.example.adventurefall22.service.ReservationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class Setup implements ApplicationRunner {

    ReservationRepository reservationRepository;

    public Setup(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Reservation reservation = new Reservation("John doe", "John@john.dk"
                ,88888888,15,10,LocalDate.of(2022, 10,10),null,1234567);

        reservationRepository.save(reservation);
    }
}
