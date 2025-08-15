package com.liseMeitnerWohnheim.repo;

import com.liseMeitnerWohnheim.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

}
