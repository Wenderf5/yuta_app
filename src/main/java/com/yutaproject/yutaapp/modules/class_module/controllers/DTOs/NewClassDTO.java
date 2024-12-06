package com.yutaproject.yutaapp.modules.class_module.controllers.DTOs;

public class NewClassDTO {
    private String name;
    private int year;

    public NewClassDTO(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }
}
