package com.yutaproject.yutaapp.modules.discipline_module.services;

import com.yutaproject.yutaapp.entities.discipline_entity.Discipline;
import com.yutaproject.yutaapp.entities.discipline_entity.DisciplineRepository;
import com.yutaproject.yutaapp.entities.teacher_entity.Teacher;
import com.yutaproject.yutaapp.entities.teacher_entity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDisciplineService {
    private DisciplineRepository disciplineRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public UpdateDisciplineService(
            DisciplineRepository disciplineRepository,
            TeacherRepository teacherRepository
    ) {
        this.disciplineRepository = disciplineRepository;
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<String> updateNameDiscipline(Long id, String newName) {
        try {
            Optional<Discipline> discipline_db = this.disciplineRepository.findById(id);
            if (discipline_db.isEmpty()) {
                return new ResponseEntity<String>("Essa disciplina não existe!", HttpStatus.NOT_FOUND);
            }
            Discipline discipline = discipline_db.get();
            discipline.setName(newName);
            this.disciplineRepository.save(discipline);
            return new ResponseEntity<String>("Nome alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Erro ao alterar o nome da disciplina!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateWorkloadDiscipline(Long id, int newWorkload) {
        try {
            Optional<Discipline> discipline_db = this.disciplineRepository.findById(id);
            if (discipline_db.isEmpty()) {
                return new ResponseEntity<String>("Essa disciplina não existe!", HttpStatus.NOT_FOUND);
            }
            Discipline discipline = discipline_db.get();
            discipline.setWorkload(newWorkload);
            this.disciplineRepository.save(discipline);
            return new ResponseEntity<String>("Carga horária alterada com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao alterar a carga horária da disciplina!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateTeacherDiscipline(Long id, Long newTeacher) {
        try {
            Optional<Discipline> discipline_db = this.disciplineRepository.findById(id);
            if (discipline_db.isEmpty()) {
                return new ResponseEntity<String>("Essa disciplina não existe!", HttpStatus.NOT_FOUND);
            }
            Optional<Teacher> teacher_db = this.teacherRepository.findById(newTeacher);
            if (teacher_db.isEmpty()) {
                return new ResponseEntity<String>("Esse professor não existe!", HttpStatus.NOT_FOUND);
            }
            Discipline discipline = discipline_db.get();
            discipline.setTeacher(newTeacher);
            this.disciplineRepository.save(discipline);
            return new ResponseEntity<String>("Professor alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao alterar o professor da disciplina!", HttpStatus.BAD_REQUEST);
        }
    }
}
