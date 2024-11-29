package com.yutaproject.yutaapp.modules.teacher_module.services;

import com.yutaproject.yutaapp.entities.teacher_entity.Teacher;
import com.yutaproject.yutaapp.entities.teacher_entity.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTeachersService {
    private TeacherRepository teacherRepository;

    @Autowired
    public GetAllTeachersService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public ResponseEntity getAllTeachersService() {
        try {
            List<Teacher> teachers = this.teacherRepository.findAll();
            return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao buscas pelos professores!", HttpStatus.BAD_REQUEST);
        }
    }
}
