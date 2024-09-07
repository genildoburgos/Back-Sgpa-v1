package br.edu.ufape.poo.sgpa.model;


import br.edu.ufape.poo.sgpa.model.enums.StatusDePagamento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table ( name = "membro", schema = "academia")
public class Membro extends Pessoa {

    @Column(name = "numero_de_matricula")
    private String numeroDeMatricula;

    @Enumerated(EnumType.STRING)
    @Column(name="status_de_pagamento")
    private StatusDePagamento statusDePagamento;

    @OneToMany
    @Column(name = "matricula_id")
    private List<Matricula> matricula;

    @OneToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

//    Quando for implementado a classe turma no sistema, atualizar:
//    @ManyToMany
//    @JoinColumn(name = "turma_id")
//    private Turma turma;


    public Membro(List<Matricula> matricula, String numeroDeMatricula, Responsavel responsavel, StatusDePagamento statusDePagamento) {
        this.matricula = matricula;
        this.numeroDeMatricula = numeroDeMatricula;
        this.responsavel = responsavel;
        this.statusDePagamento = statusDePagamento;
    }

    public Membro(String nome, String cpf, String sexo, LocalDate dataDeNascimento, String telefone, String contatoDeEmergencia, String email, List<Matricula> matricula, String numeroDeMatricula, Responsavel responsavel, StatusDePagamento statusDePagamento) {
        super(nome, cpf, sexo, dataDeNascimento, telefone, contatoDeEmergencia, email);
        this.matricula = matricula;
        this.numeroDeMatricula = numeroDeMatricula;
        this.responsavel = responsavel;
        this.statusDePagamento = statusDePagamento;
    }

    public Membro() {

    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membro membro)) return false;
        return Objects.equals(getNumeroDeMatricula(), membro.getNumeroDeMatricula()) && getStatusDePagamento() == membro.getStatusDePagamento() && Objects.equals(getMatricula(), membro.getMatricula()) && Objects.equals(getResponsavel(), membro.getResponsavel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumeroDeMatricula(), getStatusDePagamento(), getMatricula(), getResponsavel());
    }

    @Override
    public String toString() {
        return "Membro{" +
                "matricula=" + matricula +
                ", numeroDeMatricula='" + numeroDeMatricula + '\'' +
                ", statusDePagamento=" + statusDePagamento +
                ", responsavel=" + responsavel +
                '}';
    }
}
