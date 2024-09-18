package br.edu.ufape.poo.sgpa.model;


import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Membro extends Pessoa {

    private String numeroDeMatricula;

    @Enumerated(EnumType.STRING)
    private StatusDePagamento statusDePagamento;

    @OneToMany
    private List<Matricula> matriculas;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Responsavel responsavel;

    @ManyToMany
    private List<Turma> turmas;

    public Membro(List<Matricula> matricula, String numeroDeMatricula, Responsavel responsavel, StatusDePagamento statusDePagamento) {
        this.matriculas = matricula;
        this.numeroDeMatricula = numeroDeMatricula;
        this.responsavel = responsavel;
        this.statusDePagamento = statusDePagamento;
    }

    public Membro(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email, List<Matricula> matricula, String numeroDeMatricula, Responsavel responsavel, StatusDePagamento statusDePagamento, int idade) {
        super(nome, cpf, sexo, dataDeNascimento, telefone, contatoDeEmergencia, email, idade);
        this.matriculas = matricula;
        this.numeroDeMatricula = numeroDeMatricula;
        this.responsavel = responsavel;
        this.statusDePagamento = statusDePagamento;
    }

    public Membro() {

    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matricula) {
        this.matriculas = matricula;
    }

    public String getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(String numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public StatusDePagamento getStatusDePagamento() {
        return statusDePagamento;
    }

    public void setStatusDePagamento(StatusDePagamento statusDePagamento) {
        this.statusDePagamento = statusDePagamento;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membro membro)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNumeroDeMatricula(), membro.getNumeroDeMatricula()) && getStatusDePagamento() == membro.getStatusDePagamento() && Objects.equals(getMatriculas(), membro.getMatriculas()) && Objects.equals(getResponsavel(), membro.getResponsavel()) && Objects.equals(getTurmas(), membro.getTurmas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumeroDeMatricula(), getStatusDePagamento(), getMatriculas(), getResponsavel(), getTurmas());
    }

    @Override
    public String toString() {
        return "Membro{" +
                "matricula=" + matriculas +
                ", numeroDeMatricula='" + numeroDeMatricula + '\'' +
                ", statusDePagamento=" + statusDePagamento +
                ", responsavel=" + responsavel +
                ", turmas=" + turmas +
                '}';
    }

}
