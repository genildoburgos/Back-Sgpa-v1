package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;

import java.util.List;

public class UnidadeResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String contato;
    private List<SlotHorario> horarioDeFuncionamento;
    private String email;
    private List<Instrutor> instrutores;
    private List<Plano> planos;
    private Segmento segmento;
    private Endereco endereco;
    private Membro membro;
    private Administrador administrador;
    private List<Turma> turmas;
    private List<Sala> salas;

    public UnidadeResponse() {
    }

    public UnidadeResponse(Unidade unidade) {
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.cnpj = unidade.getCnpj();
        this.contato = unidade.getContato();
        this.email = unidade.getEmail();
        this.endereco = unidade.getEndereco();
        this.segmento = unidade.getSegmento();
        this.planos = unidade.getPlanos();
        this.instrutores = unidade.getInstrutores();
        this.membro = unidade.getMembro();
        this.turmas = unidade.getTurmas();
        this.horarioDeFuncionamento = unidade.getHorarioDeFuncionamento();
        this.administrador = unidade.getAdministrador();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public List<SlotHorario> getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(List<SlotHorario> horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
}
