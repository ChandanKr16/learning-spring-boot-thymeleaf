package me.chandankumar.learningspringbootthymeleaf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "email_unique", columnNames = "email")
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_seq", sequenceName = "student_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String course;
    private String email;
    private String phoneNumber;

    public Student(String firstName, String lastName, String course, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
