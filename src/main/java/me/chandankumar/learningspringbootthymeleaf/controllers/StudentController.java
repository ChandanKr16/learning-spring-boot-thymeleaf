package me.chandankumar.learningspringbootthymeleaf.controllers;

import jakarta.validation.Valid;
import me.chandankumar.learningspringbootthymeleaf.entities.Student;
import me.chandankumar.learningspringbootthymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model){

        if(!model.containsAttribute("student")){
            model.addAttribute("student", new Student());
        }

        return "create";
    }

    @PostMapping("/createStudent")
    public String createStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            StringBuilder error = new StringBuilder();
            result.getAllErrors().forEach(objectError -> error.append(objectError.getDefaultMessage()).append(" "));
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/students/showStudentForm";
        }

        Optional<Student> studentOptional = studentService.getByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("error", "This email is already taken");
            return "redirect:/students/showStudentForm";
        }


        studentService.add(student);
        return "redirect:/students";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.delete(id);

        return "redirect:/students";
    }

    @GetMapping(value = "/showStudentUpdateForm/{id}")
    public String showStudentUpdateForm(@PathVariable("id") Long id, Model model){

        Optional<Student> student = studentService.getById(id);

        if(student.isEmpty()){
            return "redirect:/students";
        }

        if(!model.containsAttribute("student"))
            model.addAttribute("student", student.get());

        return "update";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            StringBuilder error = new StringBuilder();
            result.getAllErrors().forEach(objectError -> error.append(objectError.getDefaultMessage()).append(" "));
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("error", error);
            return "redirect:/students/showStudentUpdateForm/"+student.getId();
        }

        Optional<Student> studentOptional = studentService.getByEmail(student.getEmail());

        if(studentOptional.isPresent() && !student.getId().equals(studentOptional.get().getId())){
            redirectAttributes.addFlashAttribute("student", student);
            redirectAttributes.addFlashAttribute("error", "This email is already taken");
            return "redirect:/students/showStudentUpdateForm/"+student.getId();
        }


        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam(value = "firstName", required = false) String firstName, Model model){

        if(firstName != null) {
            model.addAttribute("students", studentService.searchByFirstName(firstName));
        }
        else {
            model.addAttribute("students", studentService.getAll());
        }

        return "index";
    }

}
