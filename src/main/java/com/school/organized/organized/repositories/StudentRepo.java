package com.school.organized.organized.repositories;

import com.school.organized.organized.classes.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
