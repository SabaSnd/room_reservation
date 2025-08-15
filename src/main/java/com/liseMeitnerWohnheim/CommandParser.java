package com.liseMeitnerWohnheim;
import java.util.ArrayList;
import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "greet", mixinStandardHelpOptions = true, version = "1.0",
         description = "Greets the user by name and age.")
public class CommandParser implements Runnable {

    public enum Method {
        addStudent,
        makeReservation,
        cancelReservation,
        listRooms,
        listStudents,
        help
    }

    @Parameters(index = "0", description = "The method to execute. Valid values: ${COMPLETION-CANDIDATES}")
    private Method method;

    @Parameters(index = "1", description = "The user's name")
    private String name;

    @Parameters(index = "2", description = "The user's age")
    private String roomNumber;

    @Parameters(index = "3", description = "The user's email")
    private String email;

    public void run() {
        List<Student> students = new ArrayList<Student>();
        
        switch (method) {
            case addStudent:
                students.add(new Student(name, roomNumber, email));
                break;
            case makeReservation:
                break;
            case cancelReservation:
                break;
            case listRooms:
                break;
            case listStudents:
                for (Student student : students) {
                    System.out.printf("Name: %s, Room: %s, Email: %s%n", 
                                      student.getName(), 
                                      student.getRoomNumber(), 
                                      student.getEmail());
                }
                return;
            case help:  
                System.out.println("Available methods: addStudent, makeReservation, cancelReservation, listRooms, help");
                return;
            default:
                break;
        }
        System.out.printf("Method: %s, Name: %s, Age: %d%n", method, name);
        // Add logic for each method as needed
    }
}
