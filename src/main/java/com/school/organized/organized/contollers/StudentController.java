package com.school.organized.organized.contollers;

import java.util.List;

import com.school.organized.organized.classes.Student;
import com.school.organized.organized.repositories.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;
    
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {
        if(student.getName() == null) {
            throw new RuntimeException("No Valid Student entered");
        }
        studentRepo.save(student);
        return "Student " + student.getName() + " has been created.";
    }

}
