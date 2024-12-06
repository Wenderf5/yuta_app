package com.yutaproject.yutaapp.modules.class_module.services;

import com.yutaproject.yutaapp.entities.class_entity.Class;
import com.yutaproject.yutaapp.entities.class_entity.ClassRepository;
import com.yutaproject.yutaapp.entities.discipline_entity.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateClassService {
    private ClassRepository classRepository;

    @Autowired
    public UpdateClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ResponseEntity<String> updateNameClass(Long id, String newName) {
        try {
            Optional<Class> class_db = this.classRepository.findById(id);
            if (class_db.isEmpty()) {
                return new ResponseEntity<String>("Essa turma não existe!", HttpStatus.NOT_FOUND);
            }
            Class classs = class_db.get();
            classs.setName(newName);
            this.classRepository.save(classs);
            return new ResponseEntity<String>("Nome alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Erro ao alterar o nome da turma!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateYearClass(Long id, int newYear) {
        try {
            Optional<Class> class_db = this.classRepository.findById(id);
            if (class_db.isEmpty()) {
                return new ResponseEntity<String>("Essa turma não existe!", HttpStatus.NOT_FOUND);
            }
            Class classs = class_db.get();
            classs.setYear(newYear);
            this.classRepository.save(classs);
            return new ResponseEntity<String>("Ano da turma alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<String>("Erro ao alterar o ano da turma!", HttpStatus.BAD_REQUEST);
        }
    }
}
