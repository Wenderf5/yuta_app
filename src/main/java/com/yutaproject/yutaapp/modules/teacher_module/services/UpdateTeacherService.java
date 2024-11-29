package com.yutaproject.yutaapp.modules.teacher_module.services;

import com.yutaproject.yutaapp.entities.teacher_entity.Teacher;
import com.yutaproject.yutaapp.entities.teacher_entity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateTeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public UpdateTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<String> updateNameTeacher(Long id, String newName) {
        try {
            Optional<Teacher> teacher_db = this.teacherRepository.findById(id);
            if (teacher_db.isEmpty()) {
                return new ResponseEntity<String>("Esse professor não existe!", HttpStatus.NOT_FOUND);
            }
            Teacher teacher = teacher_db.get();
            teacher.setName(newName);
            this.teacherRepository.save(teacher);
            return new ResponseEntity<String>("Nome alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao alterar o nome do professor!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateEmailTeacher(Long id, String newEmail) {
        try {
            Optional<Teacher> teacher_db = this.teacherRepository.findById(id);
            if (teacher_db.isEmpty()) {
                return new ResponseEntity<String>("Esse professor não existe!", HttpStatus.NOT_FOUND);
            }
            Optional<Teacher> emailConflict = this.teacherRepository.findByEmail(newEmail);
            if (emailConflict.isPresent()) {
                Teacher teacherEmailConflict = emailConflict.get();
                return teacherEmailConflict.getEmail().equals(newEmail)
                        ? new ResponseEntity<String>("Você já está usando esse email!", HttpStatus.CONFLICT)
                        : new ResponseEntity<String>("Esse email já está sendo usado!", HttpStatus.CONFLICT);
            }
            Teacher teacher = teacher_db.get();
            teacher.setEmail(newEmail);
            this.teacherRepository.save(teacher);
            return new ResponseEntity<String>("Email alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao alterar o email do professor!", HttpStatus.BAD_REQUEST);
        }
    }
}
