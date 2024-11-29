package com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs;

public class NewTeacherDTO {
    private String name;
    private String email;

    public NewTeacherDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
