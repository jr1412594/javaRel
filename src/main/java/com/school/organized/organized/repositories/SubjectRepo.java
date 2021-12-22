package com.school.organized.organized.repositories;

import com.school.organized.organized.classes.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long>{
    
}
