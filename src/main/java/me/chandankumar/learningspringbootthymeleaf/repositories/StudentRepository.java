package me.chandankumar.learningspringbootthymeleaf.repositories;

import me.chandankumar.learningspringbootthymeleaf.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
