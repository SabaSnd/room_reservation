package com.liseMeitnerWohnheim.web;

import com.liseMeitnerWohnheim.model.Student;
import com.liseMeitnerWohnheim.repo.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
  private final StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
      this.studentRepository = studentRepository;
  }

  @GetMapping
  public List<Student> all() { return studentRepository.findAll(); }
  
  @PostMapping
  public ResponseEntity<Student> create(@RequestBody Student student) {
      if (studentRepository.existsByEmail(student.getEmail())) {
          return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok(studentRepository.save(student));
  }
}
