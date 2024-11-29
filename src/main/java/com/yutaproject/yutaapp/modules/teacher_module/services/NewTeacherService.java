package com.yutaproject.yutaapp.modules.teacher_module.services;

import com.yutaproject.yutaapp.entities.teacher_entity.Teacher;
import com.yutaproject.yutaapp.entities.teacher_entity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewTeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public NewTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<String> newTeacherService(String name, String email) {
        try {
            Optional<Teacher> teacher_db = this.teacherRepository.findByEmail(email);
            if (teacher_db.isPresent()) {
                return new ResponseEntity<String>("Erro ao cadastrar professor, esse email já está cadastrado!", HttpStatus.CONFLICT);
            }
            Teacher teacher = new Teacher(name, email);
            this.teacherRepository.save(teacher);
            return new ResponseEntity<String>("Cadastro realizado com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao cadastrar professor!", HttpStatus.BAD_REQUEST);
        }
    }
}