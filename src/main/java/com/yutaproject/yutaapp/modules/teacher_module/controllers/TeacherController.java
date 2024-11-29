package com.yutaproject.yutaapp.modules.teacher_module.controllers;

import com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs.NewTeacherDTO;
import com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs.UpdateEmailTeacherDTO;
import com.yutaproject.yutaapp.modules.teacher_module.controllers.DTOs.UpdateNameTeacherDTO;
import com.yutaproject.yutaapp.modules.teacher_module.services.DeleteTeacherService;
import com.yutaproject.yutaapp.modules.teacher_module.services.GetAllTeachersService;
import com.yutaproject.yutaapp.modules.teacher_module.services.NewTeacherService;
import com.yutaproject.yutaapp.modules.teacher_module.services.UpdateTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private NewTeacherService newTeacherService;
    private GetAllTeachersService getAllTeachersService;
    private DeleteTeacherService deleteTeacherService;
    private UpdateTeacherService updateTeacherService;

    @Autowired
    public TeacherController(
            NewTeacherService newTeacherService,
            GetAllTeachersService getAllTeachersService,
            DeleteTeacherService deleteTeacherService,
            UpdateTeacherService updateTeacherService
    ) {
        this.newTeacherService = newTeacherService;
        this.getAllTeachersService = getAllTeachersService;
        this.deleteTeacherService = deleteTeacherService;
        this.updateTeacherService = updateTeacherService;
    }

    @PostMapping
    public ResponseEntity<String> newTeacherController(@RequestBody NewTeacherDTO teacher) {
        return newTeacherService.newTeacherService(teacher.getName(), teacher.getEmail());
    }

    @GetMapping
    public ResponseEntity getAllTeachers() {
        return this.getAllTeachersService.getAllTeachersService();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable("id") Long id) {
        return this.deleteTeacherService.deleteTeacherService(id);
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<String> updateNameTeacher(
            @PathVariable("id") Long id,
            @RequestBody UpdateNameTeacherDTO updateNameTeacher
    ) {
        return this.updateTeacherService.updateNameTeacher(id, updateNameTeacher.getName());
    }

    @PatchMapping("/update-email/{id}")
    public ResponseEntity<String> updateEmailTeacher(
            @PathVariable("id") Long id,
            @RequestBody UpdateEmailTeacherDTO updateEmailTeacher
    ) {
        return this.updateTeacherService.updateEmailTeacher(id, updateEmailTeacher.getEmail());
    }
}
