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
        Long quantidade = entityManager.createQuery(
                        "SELECT COUNT(p) FROM Paciente p WHERE p.num_utente_saude = :numero",
                        Long.class)
                .setParameter("numero", paciente.getNum_utente_saude())
                .getSingleResult();

        if (quantidade > 0) {
            return ResponseEntity.badRequest().body("Número de utente já cadastrado.");
        }

        entityManager.persist(paciente);

        return ResponseEntity.ok(
                "Paciente " + paciente.getNome() + " registado com sucesso no PostgreSQL via Java!"
        );
    }
}

