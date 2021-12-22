package com.school.organized.organized.contollers;

import java.util.List;

import com.school.organized.organized.classes.Student;
import com.school.organized.organized.classes.Subject;
import com.school.organized.organized.classes.Teacher;
import com.school.organized.organized.repositories.StudentRepo;
import com.school.organized.organized.repositories.SubjectRepo;
import com.school.organized.organized.repositories.TeacherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/subjects")
@RestController
public class SubjectController {
    
    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        if(subject.getName().isEmpty()) {
            throw new RuntimeException("This subject does not exist.");
        }
        return subjectRepo.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject enrollStudentToSubject(
        @PathVariable long subjectId, 
        @PathVariable long studentId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Student student = studentRepo.findById(studentId).get();

        subject.assign(student);
        return subjectRepo.save(subject);
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    Subject assignTeacherToSubject(
        @PathVariable long subjectId, 
        @PathVariable long teacherId
    ) {
        Subject subject = subjectRepo.findById(subjectId).get();
        Teacher teacher = teacherRepo.findById(teacherId).get();

        subject.assign(teacher);
        return subjectRepo.save(subject);
    }
}
