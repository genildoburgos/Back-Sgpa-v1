package br.edu.ufape.poo.sgpa.controller.dto.response;

import br.edu.ufape.poo.sgpa.model.Pessoa;

import java.time.LocalDate;

public class PessoaResponse {
    private String nome;
    private String cpf;
    private String sexo;
    private LocalDate dataDeNascimento;
    private String telefone;
    private String contatoDeEmergencia;
    private String email;
    private int idade;

    public PessoaResponse() {
    }

    public PessoaResponse(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.sexo = pessoa.getSexo();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.telefone = pessoa.getTelefone();
        this.contatoDeEmergencia = pessoa.getContatoDeEmergencia();
        this.email = pessoa.getEmail();
        this.idade = pessoa.getIdade();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContatoDeEmergencia() {
        return contatoDeEmergencia;
    }

    public void setContatoDeEmergencia(String contatoDeEmergencia) {
        this.contatoDeEmergencia = contatoDeEmergencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
