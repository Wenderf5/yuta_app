package com.yutaproject.yutaapp.modules.discipline_module.services;

import com.yutaproject.yutaapp.entities.discipline_entity.Discipline;
import com.yutaproject.yutaapp.entities.discipline_entity.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllDisciplinesService {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public GetAllDisciplinesService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public ResponseEntity getAllDisciplinesService() {
        try {
            List<Discipline> disciplines = this.disciplineRepository.findAll();
            return new ResponseEntity<List<Discipline>>(disciplines, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao buscas pelas disciplinas!", HttpStatus.BAD_REQUEST);
        }
    }
}
