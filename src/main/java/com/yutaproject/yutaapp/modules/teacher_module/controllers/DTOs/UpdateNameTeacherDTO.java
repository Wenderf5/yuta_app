package com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs;

public class UpdateNameTeacherDTO {
    private String name;

    public UpdateNameTeacherDTO() {
    }

    public UpdateNameTeacherDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
