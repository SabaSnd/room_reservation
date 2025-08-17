package com.liseMeitnerWohnheim.repo;

import com.liseMeitnerWohnheim.model.Reservation;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

    List<Reservation> findByRoomNameAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
        Reservation.RoomName roomName, LocalDate startDate, LocalDate endDate
    );
} 
