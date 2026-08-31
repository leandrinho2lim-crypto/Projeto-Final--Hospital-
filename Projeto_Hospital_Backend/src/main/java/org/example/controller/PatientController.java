package org.example.controller;

import org.example.model.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/admissoes")
@CrossOrigin(origins = "*")
public class PatientController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<String> registarAdmissao(@RequestBody Paciente paciente) {

        if (paciente.getNome() == null || paciente.getNome().isBlank()) {
            return ResponseEntity.badRequest().body("O nome do paciente é obrigatório.");
        }
        entityManager.persist(paciente);
        return ResponseEntity.ok("Paciente " + paciente.getNome() + " registado com sucesso no PostgreSQL via Java!");
    }
}
