package com.yutaproject.yutaapp.entities.discipline_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)", length = 255, nullable = false)
    private String name;

    @Column(columnDefinition = "integer", nullable = false)
    private int workload;

    @Column(columnDefinition = "integer", nullable = false)
    private Long teacher;

    public Discipline() {
    }

    public Discipline(String name, int workload, Long teacher) {
        this.name = name;
        this.workload = workload;
        this.teacher = teacher;
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

    public int getWorklad() {
        return this.workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public Long getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }
}
