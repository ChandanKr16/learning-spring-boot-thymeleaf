package me.chandankumar.learningspringbootthymeleaf.repositories;

import me.chandankumar.learningspringbootthymeleaf.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);

    List<Student> findStudentsByFirstNameContainingIgnoreCase(String firstName);



}
