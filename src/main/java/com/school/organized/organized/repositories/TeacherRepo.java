package com.school.organized.organized.repositories;

import com.school.organized.organized.classes.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long>{
    
}
