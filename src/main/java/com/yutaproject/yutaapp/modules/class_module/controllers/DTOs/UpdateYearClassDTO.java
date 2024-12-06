package com.yutaproject.yutaapp.modules.class_module.controllers.DTOs;

public class UpdateYearClassDTO {
    private int newYear;

    public UpdateYearClassDTO() {
    }

    public UpdateYearClassDTO(int newYear) {
        this.newYear = newYear;
    }

    public int getNewYear() {
        return this.newYear;
    }
}
