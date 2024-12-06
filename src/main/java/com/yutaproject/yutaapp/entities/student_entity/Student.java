package com.yutaproject.yutaapp.entities.student_entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false, unique = true)
    private String registration;

    @Column(columnDefinition = "date", nullable = false)
    private LocalDate dateofbirth;

    public Student() {
    }

    public Student(String name, String email, String registration, LocalDate dateofbirth) {
        this.name = name;
        this.email = email;
        this.registration = registration;
        this.dateofbirth = dateofbirth;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration() {
        return this.name;
    }

    public LocalDate getDateofbirth() {
        return this.dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
}
