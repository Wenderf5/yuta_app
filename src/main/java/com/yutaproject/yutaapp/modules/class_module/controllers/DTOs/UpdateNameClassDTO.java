package com.yutaproject.yutaapp.modules.class_module.controllers.DTOs;

public class UpdateNameClassDTO {
    private String newName;

    public UpdateNameClassDTO() {
    }

    public UpdateNameClassDTO(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return this.newName;
    }
}
