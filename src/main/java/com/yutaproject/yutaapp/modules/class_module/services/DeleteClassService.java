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
public class DeleteClassService {
    private ClassRepository classRepository;

    @Autowired
    public DeleteClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ResponseEntity<String> deleteClassService(Long id) {
        try {
            Optional<Class> class_db = this.classRepository.findById(id);
            if (class_db.isPresent()) {
                this.classRepository.deleteById(id);
                return new ResponseEntity<String>("Turma apagada com sucesso!", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Essa turma não existe!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao excluir turma!", HttpStatus.BAD_REQUEST);
        }
    }
}
