package me.chandankumar.learningspringbootthymeleaf.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


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

    @NotEmpty(message = "First name cannot be empty.")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty.")
    private String lastName;

    @NotEmpty(message = "Job Title cannot be empty.")
    private String jobTitle;

    @Email(message = "Email should be well-formed.")
    private String email;

    @NotEmpty(message = "Phone number cannot be empty")
    @Length(min = 10, max = 10, message = "Invalid phone number")
    private String phoneNumber;

    public Student(String firstName, String lastName, String jobTitle, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(String firstName, String lastName, String jobTitle, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.email = email;
    }
}
