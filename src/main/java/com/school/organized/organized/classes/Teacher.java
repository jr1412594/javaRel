package com.school.organized.organized.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {
    
    @Id
    @GeneratedValue
    @Column(name = "TeacherId")
    private long id;

    @Column(name = "TeacherName")
    private String name;

    public Teacher() {
    }

    public Teacher(long id, String name) {
        this.id = id;
        this.name = name;
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
