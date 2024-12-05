package com.yutaproject.yutaapp.modules.discipline_module.controllers;

import com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs.NewDisciplineDTO;
import com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs.UpdateNameDisciplineDTO;
import com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs.UpdateTeacherDisciplineDTO;
import com.yutaproject.yutaapp.modules.discipline_module.controllers.DTOs.UpdateWorkloadDisciplineDTO;
import com.yutaproject.yutaapp.modules.discipline_module.services.DeleteDisciplineService;
import com.yutaproject.yutaapp.modules.discipline_module.services.GetAllDisciplinesService;
import com.yutaproject.yutaapp.modules.discipline_module.services.NewDisciplineService;
import com.yutaproject.yutaapp.modules.discipline_module.services.UpdateDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private NewDisciplineService newDisciplineService;
    private GetAllDisciplinesService getAllDisciplinesService;
    private DeleteDisciplineService deleteDisciplineService;
    private UpdateDisciplineService updateDisciplineService;

    @Autowired
    public DisciplineController(
            NewDisciplineService newDisciplineService,
            GetAllDisciplinesService getAllDisciplinesService,
            DeleteDisciplineService deleteTeacherService,
            UpdateDisciplineService updateDisciplineService
    ) {
        this.newDisciplineService = newDisciplineService;
        this.getAllDisciplinesService = getAllDisciplinesService;
        this.deleteDisciplineService = deleteTeacherService;
        this.updateDisciplineService = updateDisciplineService;
    }

    @PostMapping
    public ResponseEntity<String> newDiscipline(@RequestBody NewDisciplineDTO newDiscipline) {
        return this.newDisciplineService.newDisciplineService(newDiscipline.getName(), newDiscipline.getWorkload(), newDiscipline.getTeacher());
    }

    @GetMapping
    public ResponseEntity getAllDisciplines() {
        return this.getAllDisciplinesService.getAllDisciplinesService();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable("id") Long id) {
        return this.deleteDisciplineService.deleteDisciplineService(id);
    }

    @PatchMapping("/update-name/{id}")
    public ResponseEntity<String> updateNameDiscipline(
            @PathVariable("id") Long id,
            @RequestBody UpdateNameDisciplineDTO updateNameDisciplineDTO
    ) {
        return this.updateDisciplineService.updateNameDiscipline(id, updateNameDisciplineDTO.getNewName());
    }

    @PatchMapping("/update-workload/{id}")
    public ResponseEntity<String> updateWorkloadDiscipline(
            @PathVariable("id") Long id,
            @RequestBody UpdateWorkloadDisciplineDTO updateWorkloadDisciplineDTO
    ) {
        return this.updateDisciplineService.updateWorkloadDiscipline(id, updateWorkloadDisciplineDTO.getNewWorkload());
    }

    @PatchMapping("/update-teacher/{id}")
    public ResponseEntity<String> updateTeacherDiscipline(
            @PathVariable("id") Long id,
            @RequestBody UpdateTeacherDisciplineDTO updateTeacherDisciplineDTO
    ) {
        return this.updateDisciplineService.updateTeacherDiscipline(id, updateTeacherDisciplineDTO.getNewTeacher());
    }
}
