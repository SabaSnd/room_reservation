package com.liseMeitnerWohnheim;

public class Student {
    private String name;
    private String email;
    private String RoomNumber;

    public Student(String name, String email, String roomNumber) {
        this.name = name;
        this.email = email;
        this.RoomNumber = roomNumber;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getRoomNumber() {
        return RoomNumber;  
    }
}
