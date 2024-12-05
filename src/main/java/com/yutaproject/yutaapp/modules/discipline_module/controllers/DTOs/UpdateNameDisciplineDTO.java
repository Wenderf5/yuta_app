package com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs;

public class UpdateNameDisciplineDTO {
    private String newName;

    public UpdateNameDisciplineDTO() {
    }

    public UpdateNameDisciplineDTO(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return this.newName;
    }
}
