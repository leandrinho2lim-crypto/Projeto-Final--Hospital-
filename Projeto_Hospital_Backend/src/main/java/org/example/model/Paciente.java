package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospital_paciente") // Diz ao Java para ligar à tabela que criámos no DBeaver
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O SERIAL do PostgreSQL (ID automático)
    private Integer id_paciente;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private LocalDate data_nascimento;

    @Column(nullable = false, unique = true, length = 20)
    private String num_utente_saude;

    @Column(length = 15)
    private String telefone;
    @Column(length = 150)
    private String morada;
    @Column(length = 255)
    private String motivo_consulta;
    // --- GETTERS E SETTERS (As portas para o Java ler e escrever os dados) ---

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getNum_utente_saude() {
        return num_utente_saude;
    }

    public void setNum_utente_saude(String num_utente_saude) {
        this.num_utente_saude = num_utente_saude;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada=morada;
}
public String getMotivo_consulta(){
                return motivo_consulta;
        }
        public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }
}