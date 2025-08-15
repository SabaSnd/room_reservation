package com.liseMeitnerWohnheim;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.liseMeitnerWohnheim.repo.StudentRepository;


@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
    
   @Bean
  CommandLineRunner init(StudentRepository repo) {
    return args -> { /* ... */ };
  }
}
