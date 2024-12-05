package com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs;

public class UpdateWorkloadDisciplineDTO {
    private int newWorkload;

    public UpdateWorkloadDisciplineDTO() {
    }

    public UpdateWorkloadDisciplineDTO(int newWorkload) {
        this.newWorkload = newWorkload;
    }

    public int getNewWorkload() {
        return this.newWorkload;
    }
}
