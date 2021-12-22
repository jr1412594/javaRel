package com.school.organized.organized.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TeacherId")
    private long id;

    @Column(name = "TeacherName")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects = new HashSet<>();
    
    
    public Teacher() {
    }
    
    public Teacher(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
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
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
    
}
