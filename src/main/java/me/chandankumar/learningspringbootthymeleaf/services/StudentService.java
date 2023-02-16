package me.chandankumar.learningspringbootthymeleaf.services;

import me.chandankumar.learningspringbootthymeleaf.entities.Student;
import me.chandankumar.learningspringbootthymeleaf.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id){
        if(studentRepository.findById(id).isPresent()){
            studentRepository.delete(studentRepository.findById(id).get());
        }
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> getByEmail(String email){
        return studentRepository.findByEmail(email);
    }

}
