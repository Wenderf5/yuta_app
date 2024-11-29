package com.yutaproject.yutaapp.modules.teacher_module.services;

import com.yutaproject.yutaapp.entities.teacher_entity.Teacher;
import com.yutaproject.yutaapp.entities.teacher_entity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteTeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public DeleteTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity<String> deleteTeacherService(Long id) {
        try {
            Optional<Teacher> teacher_db = this.teacherRepository.findById(id);
            if (teacher_db.isPresent()) {
                this.teacherRepository.deleteById(id);
                return new ResponseEntity<String>("Professor apagado com sucesso!", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Esse professor não existe!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao excluir professor!", HttpStatus.BAD_REQUEST);
        }
    }
}
