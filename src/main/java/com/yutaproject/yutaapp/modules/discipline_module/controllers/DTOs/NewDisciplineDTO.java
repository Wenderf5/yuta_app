package com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs;

public class NewDisciplineDTO {
    private String name;
    private int workload;
    private Long teacher;

    public NewDisciplineDTO(String name, int workload, Long teacher) {
        this.name = name;
        this.workload = workload;
        this.teacher = teacher;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkload() {
        return this.workload;
    }

    public Long getTeacher() {
        return this.teacher;
    }
}
