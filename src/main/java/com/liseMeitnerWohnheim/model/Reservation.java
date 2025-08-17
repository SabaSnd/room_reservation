package com.liseMeitnerWohnheim.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
    public enum RoomName {
        COMMON_ROOM,
        JOFE_ROOM,
        FITNESS_ROOM,
        GRILL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RoomName roomName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private LocalDateTime requestedDate;

    public Reservation() {
        // Default constructor for JPA
    }

    public Reservation(RoomName roomName, Student student, LocalDate startDate, LocalDate endDate) {
        this.roomName = roomName;
        this.student = student;
        this.startDate = startDate;
        this.endDate = endDate;
        this.requestedDate = LocalDateTime.now();
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public RoomName getRoomName() { return roomName; }
    public void setRoomName(RoomName roomName) { this.roomName = roomName; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDateTime getRequestedDate() { return requestedDate; }
    public void setRequestedDate(LocalDateTime requestedDate) { this.requestedDate = requestedDate; }
}