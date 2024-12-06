package com.yutaproject.yutaapp.modules.class_module.controllers;

import com.yutaproject.yutaapp.modules.class_module.controllers.DTOs.NewClassDTO;
import com.yutaproject.yutaapp.modules.class_module.controllers.DTOs.UpdateNameClassDTO;
import com.yutaproject.yutaapp.modules.class_module.controllers.DTOs.UpdateYearClassDTO;
import com.yutaproject.yutaapp.modules.class_module.services.DeleteClassService;
import com.yutaproject.yutaapp.modules.class_module.services.NewClassService;
import com.yutaproject.yutaapp.modules.class_module.services.UpdateClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
public class ClassController {
    private NewClassService newClassService;
    private DeleteClassService deleteClassService;
    private UpdateClassService updateClassService;

    @Autowired
    public ClassController(
            NewClassService newClassService,
            DeleteClassService deleteClassService,
            UpdateClassService updateClassService
    ) {
        this.newClassService = newClassService;
        this.deleteClassService = deleteClassService;
        this.updateClassService = updateClassService;
    }

    @PostMapping
    public ResponseEntity<String> newaClass(@RequestBody NewClassDTO newClass) {
        return this.newClassService.newClassService(newClass.getName(), newClass.getYear());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> newaClass(@PathVariable("id") Long id) {
        return this.deleteClassService.deleteClassService(id);
    }

    @PatchMapping("/update-class-name/{id}")
    public ResponseEntity<String> updateNameClass(
            @PathVariable("id") Long id,
            @RequestBody UpdateNameClassDTO updateNameClassDTO
    ) {
        return this.updateClassService.updateNameClass(id, updateNameClassDTO.getNewName());
    }

    @PatchMapping("/update-class-year/{id}")
    public ResponseEntity<String> updateYearClass(
            @PathVariable("id") Long id,
            @RequestBody UpdateYearClassDTO updateYearClass
    ) {
        return this.updateClassService.updateYearClass(id, updateYearClass.getNewYear());
    }
}
