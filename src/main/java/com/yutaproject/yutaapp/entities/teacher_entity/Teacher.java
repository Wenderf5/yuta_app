package com.yutaproject.yutaapp.entities.teacher_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String email;

    public Teacher() {
    }

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
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
}
