package com.liseMeitnerWohnheim.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.liseMeitnerWohnheim.model.Reservation;
import com.liseMeitnerWohnheim.model.Student;
import com.liseMeitnerWohnheim.repo.ReservationRepository;
import com.liseMeitnerWohnheim.repo.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final StudentRepository studentRepository;

    public ReservationController(ReservationRepository reservationRepository, StudentRepository studentRepository) {
        this.reservationRepository = reservationRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public String reserveRoom(@RequestBody ReservationRequst reservationRequest) {
        if (reservationRequest.getRoomName() == null || reservationRequest.getStartDate() == null || reservationRequest.getEndDate() == null) {
            return "Invalid reservation data";
        }

        // Check for existing reservations
        boolean isAvailable = reservationRepository.findByRoomNameAndEndDateGreaterThanEqualAndStartDateLessThanEqual(
                reservationRequest.getRoomName(), reservationRequest.getStartDate(), reservationRequest.getEndDate()).isEmpty();

        if (!isAvailable) {
            return "Room is already reserved for the selected dates";
        }

        // Save the reservation
        // find student by ID 
        Student student = this.studentRepository.findById(reservationRequest.getStudentId())
            .orElseThrow(() -> new RuntimeException("Student not found"));
       
        Reservation reservation = new Reservation(
                reservationRequest.getRoomName(),
                student,
                reservationRequest.getStartDate(),
                reservationRequest.getEndDate()
        );
        reservationRepository.save(reservation);
        return "Reservation successful";
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();  
    }
    public static class ReservationRequst {
        private Reservation.RoomName roomName;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long studentId;

        // Getters and Setters
        public Reservation.RoomName getRoomName() { return roomName; }
        public void setRoomName(Reservation.RoomName roomName) { this.roomName = roomName; }
        public Long getStudentId() { return studentId; }
        public void setStudentId(Long studentId) { this.studentId = studentId; }
        public LocalDate getStartDate() { return startDate; }
        public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

        public LocalDate getEndDate() { return endDate; }
        public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    }
    
}


