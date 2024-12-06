package com.yutaproject.yutaapp.entities.class_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "integer", nullable = false)
    private int year;

    public Class() {
    }

    public Class(String name, int year) {
        this.name = name;
        this.year = year;
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

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
