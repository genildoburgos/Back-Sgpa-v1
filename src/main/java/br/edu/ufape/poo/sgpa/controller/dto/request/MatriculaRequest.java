package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.Matricula;
import br.edu.ufape.poo.sgpa.model.Membro;
import br.edu.ufape.poo.sgpa.model.Turma;
import br.edu.ufape.poo.sgpa.model.enums.StatusDaMatricula;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MatriculaRequest {
    @NotNull
    private LocalDate dataDeMatricula;
    @NotNull
    private LocalDate dataDeExpiracao;
    @NotNull
    private StatusDaMatricula statusDaMatricula;
    @NotNull
    private Membro membro;
    @NotNull
    private Turma turma;

    public MatriculaRequest() {}

    public Membro getMembro(){return membro;}

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Turma getTurma(){return turma;}
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(LocalDate dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public LocalDate getDataDeExpiracao() {
        return dataDeExpiracao;
    }

    public void setDataDeExpiracao(LocalDate dataDeExpiracao) {
        this.dataDeExpiracao = dataDeExpiracao;
    }

    public StatusDaMatricula getStatusDaMatricula() {
        return statusDaMatricula;
    }

    public void setStatusDaMatricula(StatusDaMatricula statusDaMatricula) {
        this.statusDaMatricula = statusDaMatricula;
    }

    public Matricula toMatricula() {
        Matricula matricula = new Matricula();
        matricula.setDataDeMatricula(dataDeMatricula);
        matricula.setDataDeExpiracao(dataDeExpiracao);
        matricula.setStatusDaMatricula(statusDaMatricula);
        matricula.setMembro(membro);
        matricula.setTurma(turma);

        return matricula;
    }
}
