package br.edu.ufape.poo.sgpa.controller.dto.request;

import br.edu.ufape.poo.sgpa.model.*;
import br.edu.ufape.poo.sgpa.model.enums.Segmento;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UnidadeRequest {
    @NotNull
    private String nome;
    @NotNull
    private String cnpj;
    private String contato;
    private List<SlotHorario> horarioDeFuncionamento;
    private String email;
    private List<Instrutor> instrutores;
    private List<Plano> planos;
    private Segmento segmento;
    @NotNull
    private Endereco endereco;
    private Membro membro;
    @NotNull
    private Administrador administrador;
    private List<Turma> turmas;
    @NotNull
    private List<Sala> salas;

    public UnidadeRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }

    public  String getCnpj() {
        return cnpj;
    }

    public void setCnpj( String cnpj) {
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

    public Unidade toUnidade(){
        Unidade unidade = new Unidade();

        unidade.setNome( getNome() );
        unidade.setCnpj( getCnpj() );
        unidade.setContato( getContato() );
        unidade.setHorarioDeFuncionamento( getHorarioDeFuncionamento() );
        unidade.setEmail( getEmail() );
        unidade.setInstrutores( getInstrutores() );
        unidade.setPlanos( getPlanos() );
        unidade.setSegmento( getSegmento() );
        unidade.setEndereco( getEndereco() );
        unidade.setMembro( getMembro() );
        unidade.setAdministrador( getAdministrador() );
        unidade.setTurmas( getTurmas() );
        unidade.setSalas( getSalas() );

        return unidade;
    }
}
