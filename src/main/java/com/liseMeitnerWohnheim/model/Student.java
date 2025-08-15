package com.liseMeitnerWohnheim.model;
import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serial in Postgres
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;
    @Column(unique = true, nullable = false, length = 120)
    private String email;

    @Column(nullable = false, length = 120)
    private String RoomNumber;

    public Student() {
        // Default constructor for JPA
    }
    public Student(String name, String email, String roomNumber) {
        this.fullName = name;
        this.email = email;
        this.RoomNumber = roomNumber;
    }
   // getters/setters
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String n) { this.fullName = n; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public String getRoomNumber() { return RoomNumber; }
    public void setRoomNumber(String r) { this.RoomNumber = r; }
}
