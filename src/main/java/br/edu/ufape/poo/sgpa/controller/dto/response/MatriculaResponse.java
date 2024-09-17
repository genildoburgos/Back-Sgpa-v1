package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;


import java.time.LocalDate;

public class MatriculaResponse {
    private Long id;
    private LocalDate dataDeMatricula;
    private LocalDate dataDeExpiracao;
    private StatusDaMatricula statusDaMatricula;
    private Membro membro;
    private Turma turma;

    public MatriculaResponse() {
    }

    public MatriculaResponse(LocalDate dataDeMatricula, LocalDate dataDeExpiracao, StatusDaMatricula statusDaMatricula, Membro membro, Turma turma) {
        this.dataDeMatricula = dataDeMatricula;
        this.dataDeExpiracao = dataDeExpiracao;
        this.statusDaMatricula = statusDaMatricula;
        this.membro = membro;
        this.turma = turma;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataDeMatricula() {
        return dataDeMatricula;
    }

    public LocalDate getDataDeExpiracao() {
        return dataDeExpiracao;
    }

    public StatusDaMatricula getStatusDaMatricula() {
        return statusDaMatricula;
    }

    public Membro getMembro() {
        return membro;
    }

    public Turma getTurma() {
        return turma;
    }
}
