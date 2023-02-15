package me.chandankumar.learningspringbootthymeleaf.controllers;

import me.chandankumar.learningspringbootthymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    private String getStudents(Model model){
        model.addAttribute("students", studentService.getAll());
        return "index";
    }

    @GetMapping("/create")
    private String createStudent(Model model){
        return "create";
    }



}
