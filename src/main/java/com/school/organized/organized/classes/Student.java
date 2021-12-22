package com.school.organized.organized.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private long id;

    @Column(name = "StudentName")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    Set<Subject> subjects = new HashSet<>();
    
    public Set<Subject> getSubjects() {
        return subjects;
    }


    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }


    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Student() {
    }


    
    
    public long getId() {
        return id;
    }
    
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
    
}
