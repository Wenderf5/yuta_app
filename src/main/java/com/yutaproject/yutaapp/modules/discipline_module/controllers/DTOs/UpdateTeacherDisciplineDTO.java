package com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs;

public class UpdateTeacherDisciplineDTO {
    private Long newTeacher;

    public UpdateTeacherDisciplineDTO() {
    }

    public UpdateTeacherDisciplineDTO(Long newTeacher) {
        this.newTeacher = newTeacher;
    }

    public Long getNewTeacher() {
        return this.newTeacher;
    }
}
