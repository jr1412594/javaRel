package com.school.organized.organized.contollers;


import java.util.List;

import com.school.organized.organized.classes.Teacher;
import com.school.organized.organized.repositories.TeacherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepo teacherRepo;
    
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        if(teacher.getName().isEmpty()) {
            throw new RuntimeException("This teacher is not valid");
        }
        return teacherRepo.save(teacher);
    }

}
