package com.yutaproject.yutaapp.modules.class_module.services;

import com.yutaproject.yutaapp.entities.class_entity.Class;
import com.yutaproject.yutaapp.entities.class_entity.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewClassService {
    private ClassRepository classRepository;

    @Autowired
    public NewClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ResponseEntity<String> newClassService(String name, int year) {
        try {
            Optional<Class> class_db = this.classRepository.findByName(name);
            if (class_db.isPresent()) {
                return new ResponseEntity<String>("Já existe uma turma com esse nome!", HttpStatus.CONFLICT);
            }
            Class newClass = new Class(name, year);
            this.classRepository.save(newClass);
            return new ResponseEntity<String>("Turma criada com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao criar turma!", HttpStatus.BAD_REQUEST);
        }
    }
}
