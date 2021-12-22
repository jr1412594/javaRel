package com.school.organized.organized.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "StudentId")
    private long id;

    @Column(name = "StudentName")
    private String name;

    
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
