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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataDeMatricula(LocalDate dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public void setDataDeExpiracao(LocalDate dataDeExpiracao) {
        this.dataDeExpiracao = dataDeExpiracao;
    }

    public void setStatusDaMatricula(StatusDaMatricula statusDaMatricula) {
        this.statusDaMatricula = statusDaMatricula;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
