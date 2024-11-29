package com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs;

public class UpdateEmailTeacherDTO {
    private String email;

    public UpdateEmailTeacherDTO() {
    }

    public UpdateEmailTeacherDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
