package com.yutaproject.yutaapp.modules.discipline_module.services;

import com.yutaproject.yutaapp.entities.discipline_entity.Discipline;
import com.yutaproject.yutaapp.entities.discipline_entity.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteDisciplineService {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public DeleteDisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public ResponseEntity<String> deleteDisciplineService(Long id) {
        try {
            Optional<Discipline> discipline_db = this.disciplineRepository.findById(id);
            if (discipline_db.isPresent()) {
                this.disciplineRepository.deleteById(id);
                return new ResponseEntity<String>("Disciplina apagada com sucesso!", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Essa disciplina não existe!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao excluir disciplina!", HttpStatus.BAD_REQUEST);
        }
    }
}
