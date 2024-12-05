package com.yutaproject.yutaapp.modules.discipline_module.services;

import com.yutaproject.yutaapp.entities.discipline_entity.Discipline;
import com.yutaproject.yutaapp.entities.discipline_entity.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewDisciplineService {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public NewDisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public ResponseEntity<String> newDisciplineService(String name, int workload, Long teacher) {
        try {
            Discipline newDiscipline = new Discipline(name, workload, teacher);
            this.disciplineRepository.save(newDiscipline);
            return new ResponseEntity<String>("Disciplina cadastrada com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar disciplina!", HttpStatus.BAD_REQUEST);
        }
    }
}
