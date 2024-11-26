package com.yutaproject.yutaapp.modules.teacher_module.controllers;

import com.yutaproject.yutaapp.modules.teacher_module.services.NewTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private NewTeacherService newTeacherService;

    @Autowired
    public TeacherController(NewTeacherService newTeacherService) {
        this.newTeacherService = newTeacherService;
    }

    @PostMapping
    public String newTeacherController() {
        return "New teacher";
    }
}
