package com.example.adventurefall22.repository;

import com.example.adventurefall22.entity.Activity;
import com.example.adventurefall22.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ActivityRepository extends JpaRepository<Activity, String> {

    public boolean existsByNameAndReservation_Date(String activityId, LocalDate reservationDate);
}
